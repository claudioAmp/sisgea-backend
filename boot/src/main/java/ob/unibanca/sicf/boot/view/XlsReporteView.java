package ob.unibanca.sicf.boot.view;

import ob.commons.excel.util.ConvertionUtil;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.view.AbstractView;

import ob.unibanca.sicf.generadorconsultas.model.Campo;

import java.math.BigDecimal;
import java.util.List;

public class XlsReporteView extends AbstractView {
    private static final String NOMBRE_REPORTE = "Resultado Consulta";
    private static final String MIME_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String EXTENSION_XLSX = ".xlsx";
    private static final String RUTA_TEMPLATES = "xlsx/";
    private static final String PARAM_REPORT_NAME = "name";
    private static final String PARAM_REPORT_PARAMS = "params";
    private static final String PARAM_REPORT_TEMPLATE = "template";
    private static final String FORMATO_FECHA = "dd/MM/yyyy";
    // Parámetros de tabla reporte
    private static final int ROW_START = 1;
    private static final int COLUMN_START = 1;
    // 
    private static final int LETRAS_POR_FILTRO = 6;

    public XlsReporteView() {
        setContentType(MIME_TYPE);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        model.putIfAbsent(PARAM_REPORT_NAME, NOMBRE_REPORTE);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Hoja1");
        List<Map<String, Object>> cuerpo = (List<Map<String, Object>>) model.get("consulta");
        List<Campo> campos = (List<Campo>) model.get("campos");

        Counter counter_row = new Counter(ROW_START);

        List<Integer> numeroLetrasColumna = new ArrayList<>();

        Row cabeceraRow = sheet.createRow(counter_row.next());

        Counter cabecera_column = new Counter(COLUMN_START);

        String filtroAddress = ConvertionUtil.intToColumnName(COLUMN_START)  +
        ConvertionUtil.intToRowName(ROW_START) + ":" +
        ConvertionUtil.intToColumnName(COLUMN_START + campos.size() - 1) + 
        ConvertionUtil.intToRowName(ROW_START);

        campos.forEach(c->{
            numeroLetrasColumna.add(c.getAlias().length() + LETRAS_POR_FILTRO);
            Cell celdaCabecera = cabeceraRow.createCell(cabecera_column.next());
            celdaCabecera.setCellValue(c.getAlias());
            celdaCabecera.setCellStyle(getEstiloCabeceras(workbook));
        });

        SimpleDateFormat format = new SimpleDateFormat(FORMATO_FECHA);

        cuerpo.forEach((fila) -> {
            Row reporteRow = sheet.createRow(counter_row.next());
            Counter counter_column = new Counter(COLUMN_START);
            campos.forEach((campo) -> {
                int i = counter_column.next();
                Object v = fila.get(campo.getCampo());
                if(v==null)
                    return;
                int num_letras = 0;
                switch (campo.getIdTipoDato()) {
                    case "DATE": {
                        Date date = new Date(((Timestamp) v).getTime());
                        String dateString = format.format(date);
                        reporteRow.createCell(i).setCellValue(dateString);
                        num_letras = dateString.length();
                        break;
                    }
                    case "NUMBER": {
                        double valorDouble = ((BigDecimal) v).doubleValue();
                        reporteRow.createCell(i).setCellValue(valorDouble);
                        num_letras = String.valueOf(valorDouble).length();
                        break;
                    }
                    default: {
                        reporteRow.createCell(i).setCellValue(v.toString());
                        num_letras = v.toString().length();
                    }
                }
                if(num_letras>numeroLetrasColumna.get(i-COLUMN_START))
                    numeroLetrasColumna.set(i-COLUMN_START, num_letras);
            });
        });

        sheet.setAutoFilter(CellRangeAddress.valueOf(filtroAddress));
        Counter counter_columns = new Counter(COLUMN_START);
        numeroLetrasColumna.forEach((numLetras)->{
            sheet.setColumnWidth(counter_columns.next(), numLetras * 256);
        });

        String nombreReporte = (String) model.get(PARAM_REPORT_NAME);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + nombreReporte + EXTENSION_XLSX);
        response.setContentType(getContentType());
        renderReport(workbook, response);
    }

    protected void renderReport(Workbook workbook, HttpServletResponse response) throws IOException {
        workbook.write(response.getOutputStream());
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    public CellStyle getEstiloCabeceras(Workbook wb){
		byte[] rgbByte = new byte[]{ (byte)-1, (byte)33, (byte)89, (byte)103 };
        XSSFColor color = new XSSFColor(rgbByte);
        color.setRgb(rgbByte);
        CellStyle estiloCabeceras = wb.createCellStyle();
        ((XSSFCellStyle) estiloCabeceras).setFillBackgroundColor(color);
        estiloCabeceras.setAlignment(CellStyle.ALIGN_CENTER);
        return estiloCabeceras;
    }
}

/*
    Clase utilizada para obtener los indices dentro de los bloques forEach
*/
class Counter {
    int i;

    Counter() {
        this.i = 1;
    }

    Counter(int i) {
        this.i = i;
    }

    int next() {
        return i++;
    }
}