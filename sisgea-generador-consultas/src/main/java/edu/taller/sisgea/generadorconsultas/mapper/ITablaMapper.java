package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Tabla;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTabla;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ITablaMapper extends IMantenibleMapper<Tabla>{
	List<Tabla> buscarTodos();
	List<Tabla> buscarPorCriterios(CriterioBusquedaTabla criterio);
}
