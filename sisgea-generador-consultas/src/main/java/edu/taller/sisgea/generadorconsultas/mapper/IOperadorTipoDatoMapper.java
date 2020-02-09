package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.OperadorTipoDato;
import edu.taller.sisgea.generadorconsultas.model.OperadoresTipoDato;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOperadorTipoDatoMapper extends IMantenibleMapper<OperadorTipoDato> {
   
	List<OperadorTipoDato> buscarTodos();
	
	List<OperadorTipoDato> buscarPorCriterios(CriterioBusquedaOperadorTipoDato criterio);
	
	List<OperadoresTipoDato> buscarPorGruposTipoDato(CriterioBusquedaOperadorTipoDato criterio);
}

