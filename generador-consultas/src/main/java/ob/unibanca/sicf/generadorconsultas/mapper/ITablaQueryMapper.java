package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;


@Mapper
public interface ITablaQueryMapper extends IMantenibleMapper<TablaQuery>{
	List<TablaQuery> buscarTodos();
	List<TablaQuery> buscarPorCriterios(CriterioBusquedaTablaQuery criterio);
}
