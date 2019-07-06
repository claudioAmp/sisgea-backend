package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaOnJoin;


@Mapper
public interface ITablaOnJoinMapper extends IMantenibleMapper<TablaOnJoin>{
	List<TablaOnJoin> buscarTodos();
	List<TablaOnJoin> buscarPorCriterios(CriterioBusquedaTablaOnJoin criterio);
}
