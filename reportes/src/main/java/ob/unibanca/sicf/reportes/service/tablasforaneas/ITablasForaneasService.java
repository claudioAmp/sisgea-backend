package ob.unibanca.sicf.reportes.service.tablasforaneas;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.reportes.model.TablasForaneas;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaTablasForaneas;

public interface ITablasForaneasService extends IMantenibleService<TablasForaneas> {
	
	List<TablasForaneas> buscarTodosTablasForaneas();
	
	List<TablasForaneas> buscarPorCriterios(CriterioBusquedaTablasForaneas criterio);
}
