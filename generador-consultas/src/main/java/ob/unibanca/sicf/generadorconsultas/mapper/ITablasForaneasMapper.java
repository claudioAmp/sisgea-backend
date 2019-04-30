package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.TablasForaneas;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablasForaneas;


@Mapper
public interface ITablasForaneasMapper extends IMantenibleMapper<TablasForaneas>{
	
	List<TablasForaneas> buscarTodos();
	
	List<TablasForaneas> buscarPorCriterios(CriterioBusquedaTablasForaneas criterio);
}
