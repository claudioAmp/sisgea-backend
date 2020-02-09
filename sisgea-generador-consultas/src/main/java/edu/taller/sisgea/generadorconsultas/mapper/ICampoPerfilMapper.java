package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.CampoPerfil;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface ICampoPerfilMapper extends IMantenibleMapper<CampoPerfil>{
	
	List<CampoPerfil> buscarTodos();
	
	List<CampoPerfil> buscarPorCriterios(CriterioBusquedaCampoPerfil criterio);
	
	List<CampoPerfil> buscarCamposAsignables(CriterioBusquedaCampoPerfil criterio);
	
	void actualizarCamposDePerfil(int idPerfil,String listaModificacion,String usuario);
	
	void eliminarCamposDePerfilMasivo(@Param("idPerfil") Integer idPerfil);
	
	void registrarCamposDePerfilMasivo(@Param("lista") List<CampoPerfil> lista);
}