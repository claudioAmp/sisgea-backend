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

import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.view.AbstractView;

import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;

import java.math.BigDecimal;
import java.util.List;

public class XlsReporteView extends AbstractView {
    private static final String NOMBRE_REPORTE = "Resultado Consulta";
    private static final String MIME_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String EXTENSION_XLSX = ".xlsx";
    private static final String PARAM_REPORT_NAME = "name";
    private static final String FORMATO_FECHA = "dd/MM/yyyy";
    private static final float FACTOR_TITULO = (float) (35.0 / 20.0);
    // Parámetros de la tabla reporte
    private static final int ROW_START = 2;
    private static final int COLUMN_START = 1;
    // Permite dar el espacio correpondiente al ícono de filtro en las cabeceras de
    // la tabla generada
    private static final int LETRAS_POR_FILTRO = 6;
    // Espacio adicional dado a cada registro del reporte
    private static final int ADICIONAL_LETRAS = 1;

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
        List<CampoQuery> campos = (List<CampoQuery>) model.get("campos");

        Counter counter_row = new Counter(ROW_START);

        List<Integer> numeroLetrasColumna = new ArrayList<>();

        String filtroAddress = ConvertionUtil.intToColumnName(COLUMN_START) + ConvertionUtil.intToRowName(ROW_START + 2)
                + ":" + ConvertionUtil.intToColumnName(COLUMN_START + campos.size() - 1)
                + ConvertionUtil.intToRowName(ROW_START + 2);

        generarCabecera(sheet, counter_row, campos.size());

        Row cabeceraRow = sheet.createRow(counter_row.next());

        Counter cabecera_column = new Counter(COLUMN_START);

        campos.forEach(c -> {
            numeroLetrasColumna.add(c.getAliasCampo().length() + LETRAS_POR_FILTRO);
            Cell celdaCabecera = cabeceraRow.createCell(cabecera_column.next());
            celdaCabecera.setCellValue(c.getAliasCampo());
            celdaCabecera.setCellStyle(getEstiloCabeceras(workbook));
        });

        SimpleDateFormat format = new SimpleDateFormat(FORMATO_FECHA);

        cuerpo.forEach((fila) -> {
            Row reporteRow = sheet.createRow(counter_row.next());
            Counter counter_column = new Counter(COLUMN_START);
            campos.forEach((campo) -> {
                int i = counter_column.next();
                Object v = fila.get(campo.getCampo());
                Cell celda = reporteRow.createCell(i);
                aplicarBorderCompleto(workbook, celda);
                if (v == null)
                    return;
                int num_letras = 0;
                switch (campo.getIdTipoDato()) {
                case "DATE": {
                    Date date = new Date(((Timestamp) v).getTime());
                    String dateString = format.format(date);
                    celda.setCellValue(dateString);
                    num_letras = dateString.length();
                    break;
                }
                case "NUMBER": {
                    double valorDouble = ((BigDecimal) v).doubleValue();
                    celda.setCellValue(valorDouble);
                    num_letras = String.valueOf(valorDouble).length();
                    break;
                }
                default: {
                    celda.setCellValue(v.toString());
                    num_letras = v.toString().length();
                }
                }
                num_letras+=ADICIONAL_LETRAS;
                if (num_letras > numeroLetrasColumna.get(i - COLUMN_START))
                    numeroLetrasColumna.set(i - COLUMN_START, num_letras);
            });
        });

        sheet.setAutoFilter(CellRangeAddress.valueOf(filtroAddress));
        Counter counter_columns = new Counter(COLUMN_START);
        numeroLetrasColumna.forEach((numLetras) -> {
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

    public void generarCabecera(Sheet sheet, Counter row_counter, int cantidad_columnas) {

        SimpleDateFormat format = new SimpleDateFormat(FORMATO_FECHA);
        String titulo = "SISTEMA INTEGRAL DE COMPENSACIÓN Y FACTURACIÓN";
        String subtitulo = "Módulo de Exportación de Información de Reportes\n\n";
        String usuario = "Usuario: ";
        String fechaGeneracion = "                Fecha: " + format.format(new Date());

        // Titulo
        int fila_titulo = row_counter.next();
        CellRangeAddress rangoTitulo = generarRangoDireccion(sheet, fila_titulo, COLUMN_START,
                COLUMN_START + cantidad_columnas - 1);
        Cell celdaTitulo = generarCeldaRango(sheet, rangoTitulo, fila_titulo, COLUMN_START);
        celdaTitulo.setCellValue(getTituloFormateado(sheet.getWorkbook(), titulo));
        celdaTitulo.setCellStyle(getEstiloCentrado(sheet.getWorkbook()));
        Row rowTitle = celdaTitulo.getRow();
        rowTitle.setHeightInPoints(FACTOR_TITULO * rowTitle.getHeightInPoints());
        setBorderACeldaTitulo(sheet, rangoTitulo);

        // Subtitulo
        int fila_subt = row_counter.next();
        CellRangeAddress rangoSubtitulo = generarRangoDireccion(sheet, fila_subt, COLUMN_START,
                COLUMN_START + cantidad_columnas - 1);
        Cell celdaSubtitulo = generarCeldaRango(sheet, rangoSubtitulo, fila_subt, COLUMN_START);
        celdaSubtitulo.setCellValue(getSubtituloFormateado(sheet.getWorkbook(), subtitulo, usuario, fechaGeneracion));
        celdaSubtitulo.setCellStyle(getEstiloCentrado(sheet.getWorkbook()));
        Row rowSubtitle = celdaSubtitulo.getRow();
        rowSubtitle.setHeightInPoints(2 * FACTOR_TITULO * rowSubtitle.getHeightInPoints());
        setBorderACeldaSubtitulo(sheet, rangoSubtitulo);
    }

    public XSSFRichTextString getTituloFormateado(Workbook wb, String title) {
        XSSFRichTextString richString = new XSSFRichTextString();
        XSSFFont titleFont = (XSSFFont) wb.createFont();
        titleFont.setFontHeightInPoints((short) 14);
        titleFont.setUnderline(Font.U_SINGLE);
        titleFont.setBold(true);
        richString.append(title, titleFont);
        return richString;
    }

    public XSSFRichTextString getSubtituloFormateado(Workbook wb, String... subtitles) {
        String subtitle = "";
        for (String s : subtitles) {
            subtitle += s;
        }
        XSSFRichTextString richString = new XSSFRichTextString();
        XSSFFont subtitleFont = (XSSFFont) wb.createFont();
        subtitleFont.setFontHeightInPoints((short) 11);
        richString.append(subtitle, subtitleFont);
        return richString;
    }

    public CellStyle getEstiloCentrado(Workbook wb) {
        CellStyle wrapStyle = wb.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setAlignment(CellStyle.ALIGN_CENTER);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return wrapStyle;
    }

    public CellRangeAddress generarRangoDireccion(Sheet sheet, int fila_inicio, int fila_fin, int columna_inicio,
            int columna_fin) {
        String rangoString = ConvertionUtil.intToColumnName(columna_inicio) + ConvertionUtil.intToRowName(fila_inicio)
                + ":" + ConvertionUtil.intToColumnName(columna_fin) + ConvertionUtil.intToRowName(fila_fin);
        return CellRangeAddress.valueOf(rangoString);
    }

    public CellRangeAddress generarRangoDireccion(Sheet sheet, int fila, int columna_inicio, int columna_fin) {
        return this.generarRangoDireccion(sheet, fila, fila, columna_inicio, columna_fin);
    }

    public Cell generarCeldaRango(Sheet sheet, CellRangeAddress rangeAdress, int fila_inicio, int columna_inicio) {
        sheet.addMergedRegion(rangeAdress);
        return sheet.createRow(fila_inicio).createCell(columna_inicio);
    }

    private void setBorderACeldaTitulo(Sheet sheet, CellRangeAddress mergedRegions) {
        RegionUtil.setBorderTop(CellStyle.BORDER_THIN, mergedRegions, sheet, sheet.getWorkbook());
        RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, mergedRegions, sheet, sheet.getWorkbook());
        RegionUtil.setBorderRight(CellStyle.BORDER_THIN, mergedRegions, sheet, sheet.getWorkbook());
    }

    private void setBorderACeldaSubtitulo(Sheet sheet, CellRangeAddress mergedRegions) {
        RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, mergedRegions, sheet, sheet.getWorkbook());
        RegionUtil.setBorderRight(CellStyle.BORDER_THIN, mergedRegions, sheet, sheet.getWorkbook());
        RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, mergedRegions, sheet, sheet.getWorkbook());
    }

    public void aplicarBorderCompleto(Workbook wb, Cell celda) {
        XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        celda.setCellStyle(style);
    }

    public CellStyle getEstiloCabeceras(Workbook wb) {
        byte[] rgbByte = new byte[] { (byte) -1, (byte) 33, (byte) 89, (byte) 103 };
        byte[] rgbFont = new byte[] { (byte) -1, (byte) 255, (byte) 255, (byte) 255 };
        XSSFColor color_font = new XSSFColor();
        color_font.setRgb(rgbFont);
        Font font = wb.createFont();
        ((XSSFFont) font).setColor(color_font);
        XSSFColor color = new XSSFColor();
        color.setRgb(rgbByte);
        CellStyle estiloCabeceras = wb.createCellStyle();
        ((XSSFCellStyle) estiloCabeceras).setFillPattern(FillPatternType.SOLID_FOREGROUND);
        ((XSSFCellStyle) estiloCabeceras).setFillForegroundColor(color);
        estiloCabeceras.setFont(font);
        estiloCabeceras.setAlignment(CellStyle.ALIGN_CENTER);
        return estiloCabeceras;
    }
}

/*
 * Clase utilizada para obtener los indices dentro de los bloques forEach
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