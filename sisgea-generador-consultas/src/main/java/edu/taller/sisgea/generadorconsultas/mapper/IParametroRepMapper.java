package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.ParametroRep;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaParametroRep;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface IParametroRepMapper extends IMantenibleMapper<ParametroRep>{
	List<ParametroRep> buscarTodos();
	List<ParametroRep> buscarPorCriterios(CriterioBusquedaParametroRep criterio);
}
