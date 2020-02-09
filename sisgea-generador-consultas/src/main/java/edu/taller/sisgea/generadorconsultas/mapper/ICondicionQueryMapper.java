package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.CondicionQuery;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCondicionQuery;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ICondicionQueryMapper extends IMantenibleMapper<CondicionQuery>{
	List<CondicionQuery> buscarTodos();
	List<CondicionQuery> buscarPorCriterios(CriterioBusquedaCondicionQuery criterio);
}
