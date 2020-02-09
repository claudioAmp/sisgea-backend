package edu.taller.sisgea.generadorconsultas.service.usuarioperfil;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.UsuarioPerfil;
import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaUsuarioPerfil;




public interface IUsuarioPerfilService extends IMantenibleService<UsuarioPerfil> {
	
	List<UsuarioPerfil> buscarTodosUsuarioPerfil();
	
	List<UsuarioPerfil> buscarPorCriteriosUsuarioPerfil(CriterioBusquedaUsuarioPerfil criterio);
	
	UsuarioPerfil registrarUsuarioPerfil(UsuarioPerfil UsuarioPerfil);
	
	UsuarioPerfil actualizarUsuarioPerfil(int idUsuarioPerfil, UsuarioPerfil UsuarioPerfil);
	
	void eliminarUsuarioPerfil(int idUsuarioPerfil);
	public void actualizarPefilesUsuario(int idPerfil, String listaModificacion, String usuario);
}
