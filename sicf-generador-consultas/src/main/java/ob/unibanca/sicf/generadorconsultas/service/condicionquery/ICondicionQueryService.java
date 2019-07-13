package ob.unibanca.sicf.generadorconsultas.service.condicionquery;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.CondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCondicionQuery;

public interface ICondicionQueryService extends IMantenibleService<CondicionQuery> {
	
	List<CondicionQuery> buscarTodosParametrosRep();
	
	List<CondicionQuery> buscarPorCriteriosCondicionQuery(CriterioBusquedaCondicionQuery criterio);
	
	CondicionQuery registrarCondicionQuery(CondicionQuery CondicionQuery);
	
	CondicionQuery actualizarCondicionQuery(int idCondicionQuery, CondicionQuery CondicionQuery);
	
	void eliminarCondicionQuery(int idCondicionQuery);
	
}
