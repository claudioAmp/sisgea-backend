package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.Tabla;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTabla;


@Mapper
public interface ITablaMapper extends IMantenibleMapper<Tabla>{
	List<Tabla> buscarTodos();
	List<Tabla> buscarPorCriterios(CriterioBusquedaTabla criterio);
}
