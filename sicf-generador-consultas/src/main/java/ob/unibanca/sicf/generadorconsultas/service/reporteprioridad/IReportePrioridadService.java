package ob.unibanca.sicf.generadorconsultas.service.reporteprioridad;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.ReportePrioridad;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReportePrioridad;


public interface IReportePrioridadService extends IMantenibleService<ReportePrioridad> {
	
	List<ReportePrioridad> buscarTodosReportesPrioridades();
	
	List<ReportePrioridad> buscarPorCriterioReportesPrioridades(CriterioBusquedaReportePrioridad criterio);
	
	ReportePrioridad registrarReportePrioridad(ReportePrioridad reporte);
	
	ReportePrioridad actualizarReportePrioridad(int idQueryUsua, ReportePrioridad reporte);
	
	void eliminarReportePrioridad(int idQueryUsua);
	
}
