package ob.unibanca.sicf.reportes.service.control.vssvisa;

import java.util.List;

import ob.unibanca.sicf.reportes.model.control.ReporteControlVSSVisa;
import ob.unibanca.sicf.reportes.model.control.criterio.CriterioBusquedaReporteControlVSSVisa;

public interface IReporteControlVSSVisaService {
	List<ReporteControlVSSVisa> buscarPorFechaProceso(CriterioBusquedaReporteControlVSSVisa criterio);
}
