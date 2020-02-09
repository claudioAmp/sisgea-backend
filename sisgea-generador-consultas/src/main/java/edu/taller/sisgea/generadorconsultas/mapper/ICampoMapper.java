package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Campo;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampo;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaConjuntoCampo;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface ICampoMapper extends IMantenibleMapper<Campo>{
	List<Campo> buscarTodos();
	Campo buscarPorId(int idCampo);
	List<Campo> buscarIdTabla(int idTabla);
	List<Campo> buscarPorCriterios(CriterioBusquedaCampo criterio);
	List<Campo> buscarConjuntoCampos(CriterioBusquedaConjuntoCampo criterio);
}
