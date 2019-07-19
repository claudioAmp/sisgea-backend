package ob.unibanca.sicf.generadorconsultas.service.reporte;

import java.util.List;

import com.github.pagehelper.Page;
import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.paginacion.PageParameter;

import java.util.Map;

public interface IReporteService extends IMantenibleService<Reporte> {
	
	List<Reporte> buscarTodosReportes();
	
	List<Reporte> buscarReporte(int idReporte);
	
	List<Reporte> buscarPorCriteriosReporte(CriterioBusquedaReporte criterio);
	
	Reporte registrarReporte(Reporte Reporte);
	
	Reporte actualizarReporte(int idReporte, Reporte Reporte);
	
	void eliminarReporte(int idReporte);
	
	void registrarReporteTotal(Reporte Reporte);
	
	Page<Map<String, Object>> ejecutarConsulta(String consulta, PageParameter pageParameter);
	
	List<Map<String, Object>> ejecutarConsulta(String consulta);
	
}
