package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.CampoQuery;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ICampoQueryMapper extends IMantenibleMapper<CampoQuery>{
	List<CampoQuery> buscarTodos();
	List<CampoQuery> buscarPorCriterios(CriterioBusquedaCampoQuery criterio);
}
