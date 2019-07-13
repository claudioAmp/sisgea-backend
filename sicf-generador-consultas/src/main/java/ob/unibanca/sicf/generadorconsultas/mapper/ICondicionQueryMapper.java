package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.CondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCondicionQuery;


@Mapper
public interface ICondicionQueryMapper extends IMantenibleMapper<CondicionQuery>{
	List<CondicionQuery> buscarTodos();
	List<CondicionQuery> buscarPorCriterios(CriterioBusquedaCondicionQuery criterio);
}
