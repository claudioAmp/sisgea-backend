package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.TablaOnJoin;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTablaOnJoin;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ITablaOnJoinMapper extends IMantenibleMapper<TablaOnJoin>{
	List<TablaOnJoin> buscarTodos();
	List<TablaOnJoin> buscarPorCriterios(CriterioBusquedaTablaOnJoin criterio);
}
