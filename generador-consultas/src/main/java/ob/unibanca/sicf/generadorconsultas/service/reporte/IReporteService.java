package ob.unibanca.sicf.generadorconsultas.service.reporte;

import java.util.List;


import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;

public interface IReporteService extends IMantenibleService<Reporte> {
	
	List<Reporte> buscarTodosReportes();
	
	List<Reporte> buscarPorCriteriosReporte(CriterioBusquedaReporte criterio);
	
	Reporte registrarReporte(Reporte Reporte);
	
	Reporte actualizarReporte(int idReporte, Reporte Reporte);
	
	void eliminarReporte(int idReporte);
	
	
}
