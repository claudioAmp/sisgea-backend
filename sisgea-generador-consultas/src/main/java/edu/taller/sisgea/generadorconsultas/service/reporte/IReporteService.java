package edu.taller.sisgea.generadorconsultas.service.reporte;

import java.util.List;

import com.github.pagehelper.Page;
import edu.taller.sisgea.generadorconsultas.model.Reporte;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import edu.taller.sisgea.generadorconsultas.model.criterio.paginacion.PageParameter;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.Map;

public interface IReporteService extends IMantenibleService<Reporte> {
	
	List<Reporte> buscarTodosReportes();
	
	List<Reporte> buscarReporte(int idReporte);
	
	List<Reporte> buscarPorCriteriosReporte(CriterioBusquedaReporte criterio);
	
	Reporte registrarReporte(Reporte Reporte);
	
	Reporte actualizarReporte(int idReporte, Reporte Reporte);
	
	void eliminarReporte(int idReporte);
	
	void detectarPAN(Reporte reporte);
	
	Reporte registrarReporteTotal(int idReporte,Reporte Reporte);
	
	Page<Map<String, Object>> ejecutarConsulta(String consulta, PageParameter pageParameter);
	
	List<Map<String, Object>> ejecutarConsulta(String consulta);
	
}
