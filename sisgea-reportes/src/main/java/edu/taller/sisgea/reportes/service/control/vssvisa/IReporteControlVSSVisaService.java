package edu.taller.sisgea.reportes.service.control.vssvisa;

import java.util.List;

import edu.taller.sisgea.reportes.model.control.ReporteControlVSSVisa;
import edu.taller.sisgea.reportes.model.control.criterio.CriterioBusquedaReporteControlVSSVisa;

public interface IReporteControlVSSVisaService {
	List<ReporteControlVSSVisa> buscarPorFechaProceso(CriterioBusquedaReporteControlVSSVisa criterio);
}
