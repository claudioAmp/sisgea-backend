package ob.unibanca.sicf.generadorconsultas.service.tablaquery;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;

public interface ITablaQueryService extends IMantenibleService<TablaQuery> {
	
	List<TablaQuery> buscarTodosTablasQuery();
	
	List<TablaQuery> buscarPorCriteriosTablaQuery(CriterioBusquedaTablaQuery criterio);
	
	TablaQuery registrarTablaQuery(TablaQuery tablaQuery);
	
	TablaQuery actualizarTablaQuery(int idTablaQuery, TablaQuery tablaQuery);
	
	void eliminarTablaQuery(int idTablaQuery);
	
}
