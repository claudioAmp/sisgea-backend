package edu.taller.sisgea.consultasgenerales.service.asincrono;

import java.util.List;
import java.util.concurrent.Future;

import edu.taller.sisgea.consultasgenerales.service.subreporttmp.SubReportTmp;


public interface IAsyncFileService {
	public Future<SubReportTmp> generateXLSXChunkToZip(List<?> subReport,
                                                       Integer chunk, String baseFileName, String templateName, String reportVarName) throws Exception;
}
