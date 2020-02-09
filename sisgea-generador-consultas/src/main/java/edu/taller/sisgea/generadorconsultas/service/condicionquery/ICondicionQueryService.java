package edu.taller.sisgea.generadorconsultas.service.condicionquery;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.CondicionQuery;
import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCondicionQuery;

public interface ICondicionQueryService extends IMantenibleService<CondicionQuery> {
	
	List<CondicionQuery> buscarTodosParametrosRep();
	
	List<CondicionQuery> buscarPorCriteriosCondicionQuery(CriterioBusquedaCondicionQuery criterio);
	
	CondicionQuery registrarCondicionQuery(CondicionQuery CondicionQuery);
	
	CondicionQuery actualizarCondicionQuery(int idCondicionQuery, CondicionQuery CondicionQuery);
	
	void eliminarCondicionQuery(int idCondicionQuery);
	
}
