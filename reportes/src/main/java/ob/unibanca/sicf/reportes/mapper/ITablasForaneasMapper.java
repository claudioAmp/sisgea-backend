package ob.unibanca.sicf.reportes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.reportes.model.TablasForaneas;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaTablasForaneas;
import ob.unibanca.sicf.reportes.service.tablasforaneas.TablasForaneasService;

@Mapper
public interface ITablasForaneasMapper extends IMantenibleMapper<TablasForaneas>{
	
	List<TablasForaneas> buscarTodos();
	
	List<TablasForaneas> buscarPorCriterios(CriterioBusquedaTablasForaneas criterio);
}
