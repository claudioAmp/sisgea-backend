package edu.taller.sisgea.generadorconsultas.service.reporteprioridad;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.ReportePrioridad;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaReportePrioridad;
import ob.commons.mantenimiento.service.IMantenibleService;


public interface IReportePrioridadService extends IMantenibleService<ReportePrioridad> {
	
	List<ReportePrioridad> buscarTodosReportesPrioridades();
	
	List<ReportePrioridad> buscarPorCriterioReportesPrioridades(CriterioBusquedaReportePrioridad criterio);
	
	ReportePrioridad registrarReportePrioridad(ReportePrioridad reporte);
	
	ReportePrioridad actualizarReportePrioridad(int idQueryUsua, ReportePrioridad reporte);
	
	void eliminarReportePrioridad(int idQueryUsua);
	
}
