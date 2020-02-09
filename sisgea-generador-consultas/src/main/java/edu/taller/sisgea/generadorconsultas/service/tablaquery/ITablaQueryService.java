package edu.taller.sisgea.generadorconsultas.service.tablaquery;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.TablaQuery;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface ITablaQueryService extends IMantenibleService<TablaQuery> {
	
	List<TablaQuery> buscarTodosTablasQuery();
	
	List<TablaQuery> buscarPorCriteriosTablaQuery(CriterioBusquedaTablaQuery criterio);
	
	TablaQuery registrarTablaQuery(TablaQuery tablaQuery);
	
	TablaQuery actualizarTablaQuery(int idTablaQuery, TablaQuery tablaQuery);
	
	void eliminarTablaQuery(int idTablaQuery);
	
}
