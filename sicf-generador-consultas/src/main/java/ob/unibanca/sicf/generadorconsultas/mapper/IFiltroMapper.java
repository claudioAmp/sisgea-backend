package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaFiltro;


@Mapper
public interface IFiltroMapper extends IMantenibleMapper<Filtro>{
	List<Filtro> buscarTodos();
	List<Filtro> buscarPorCriterios(CriterioBusquedaFiltro criterio);
}
