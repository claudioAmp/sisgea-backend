package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.TablasForaneas;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTablasForaneas;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ITablasForaneasMapper extends IMantenibleMapper<TablasForaneas>{
	
	List<TablasForaneas> buscarTodos();
	
	List<TablasForaneas> buscarPorCriterios(CriterioBusquedaTablasForaneas criterio);
}
