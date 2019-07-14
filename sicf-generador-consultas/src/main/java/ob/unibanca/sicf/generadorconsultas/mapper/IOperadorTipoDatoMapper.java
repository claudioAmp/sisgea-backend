package ob.unibanca.sicf.generadorconsultas.mapper;

import java.util.List;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.OperadorTipoDato;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOperadorTipoDatoMapper extends IMantenibleMapper<OperadorTipoDato> {
   
	List<OperadorTipoDato> buscarTodos();
	
	List<OperadorTipoDato> buscarPorCriterios(CriterioBusquedaOperadorTipoDato criterio);
}

