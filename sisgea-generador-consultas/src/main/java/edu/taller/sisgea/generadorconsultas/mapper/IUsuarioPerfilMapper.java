package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.UsuarioPerfil;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaUsuarioPerfil;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;


@Mapper
public interface IUsuarioPerfilMapper extends IMantenibleMapper<UsuarioPerfil>{
	
	List<UsuarioPerfil> buscarTodos();
	
	List<UsuarioPerfil> buscarPorCriterios(CriterioBusquedaUsuarioPerfil criterio);
	
	void actualizarPerfilesUsuario(int idPerfil, String listaModificacion, String usuario);
}
