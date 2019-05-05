package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;


@Mapper
public interface ICampoQueryMapper extends IMantenibleMapper<CampoQuery>{
	List<CampoQuery> buscarTodos();
	List<CampoQuery> buscarPorCriterios(CriterioBusquedaCampoQuery criterio);
}
