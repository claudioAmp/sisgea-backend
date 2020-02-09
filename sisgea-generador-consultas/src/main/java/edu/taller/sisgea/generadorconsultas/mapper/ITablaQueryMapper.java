package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.TablaQuery;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ITablaQueryMapper extends IMantenibleMapper<TablaQuery>{
	List<TablaQuery> buscarTodos();
	List<TablaQuery> buscarPorCriterios(CriterioBusquedaTablaQuery criterio);
}
