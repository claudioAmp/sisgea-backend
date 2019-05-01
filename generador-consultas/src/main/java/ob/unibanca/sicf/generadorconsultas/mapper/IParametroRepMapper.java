package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.ParametroRep;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaParametroRep;


@Mapper
public interface IParametroRepMapper extends IMantenibleMapper<ParametroRep>{
	List<ParametroRep> buscarTodos();
	List<ParametroRep> buscarPorCriterios(CriterioBusquedaParametroRep criterio);
}
