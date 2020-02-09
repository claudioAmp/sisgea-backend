package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Filtro;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaFiltro;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface IFiltroMapper extends IMantenibleMapper<Filtro>{
	List<Filtro> buscarTodos();
	List<Filtro> buscarPorCriterios(CriterioBusquedaFiltro criterio);
}
