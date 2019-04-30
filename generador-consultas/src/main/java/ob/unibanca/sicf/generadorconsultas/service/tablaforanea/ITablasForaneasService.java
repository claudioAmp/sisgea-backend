package ob.unibanca.sicf.generadorconsultas.service.tablaforanea;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.TablasForaneas;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablasForaneas;


public interface ITablasForaneasService extends IMantenibleService<TablasForaneas> {
	
	List<TablasForaneas> buscarTodosTablasForaneas();
	
	List<TablasForaneas> buscarPorCriteriosTablasForaneas(CriterioBusquedaTablasForaneas criterio);
}
