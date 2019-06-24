package ob.unibanca.sicf.consultasgenerales.controller.exportacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.ModelAndView;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.service.asincrono.IAsyncFileService;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5.IIncomingVisaService;
import ob.unibanca.sicf.consultasgenerales.service.subreporttmp.SubReportTmp;

public class IncomingVisaExportacionController {
	private @Autowired IIncomingVisaService incomingVisaService;
	private @Autowired IAsyncFileService asyncFileService;
	
	
	public ModelAndView exportarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTCR0 criterioBusqueda) {
		 
		System.out.println(criterioBusqueda);
		
		long inicio = System.currentTimeMillis();
		
		//response.setContentType("application/zip");
		String zipFileName = "Reporte de Transacciones SwDmpLog.zip";
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", zipFileName);
		//response.setHeader(headerKey, headerValue);
		String baseXLSXFileName = "Reporte de Transacciones SwDmpLog";
		
		//ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());

		int size = 20000;
		int start = 0;
		int chunk = 0;

		List<Future<SubReportTmp>> futures = new ArrayList<>();
		List<IncomingVisaTC5TCR0> subReportResult;
		
		/*do {
			CriterioPaginacion<CriterioBusquedaIncomingVisaTCR0> criterioPaginacion = PaginacionUtil
					.getCriterioPaginacionParaReporteXLSX(criterioBusqueda, start, size);
			subReportResult = this.tnxsSwDmpLogService
					.filtrarTxnsSwDmpLogPaginado(criterioPaginacion);
			if (!subReportResult.isEmpty()) {
				futures.add(this.asyncFileService.generateXLSXChunkToZip(subReportResult, chunk, baseXLSXFileName,
						"reporteConsultaTransaccionesSwDmpLog", "reporte"));
			}
			start += size;
			chunk++;
		} while (!subReportResult.isEmpty());
		
		*/
		return null;
	}
}
