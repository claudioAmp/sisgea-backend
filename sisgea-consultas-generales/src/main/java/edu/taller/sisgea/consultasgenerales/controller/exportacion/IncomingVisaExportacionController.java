package edu.taller.sisgea.consultasgenerales.controller.exportacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import edu.taller.sisgea.consultasgenerales.service.subreporttmp.SubReportTmp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.ModelAndView;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import edu.taller.sisgea.consultasgenerales.service.asincrono.IAsyncFileService;
import edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc5.IIncomingVisaTC5Service;
import edu.taller.sisgea.consultasgenerales.service.subreporttmp.SubReportTmp;

public class IncomingVisaExportacionController {
	private @Autowired IIncomingVisaTC5Service incomingVisaTC5Service;
	private @Autowired IAsyncFileService asyncFileService;
	
	
	public ModelAndView exportarPorCriteriosTCR0(CriterioBusquedaIncomingVisaTC5 criterioBusqueda) {
		 
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
			CriterioPaginacion<CriterioBusquedaIncomingVisaTC5> criterioPaginacion = PaginacionUtil
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
