package ob.unibanca.sicf.generadorconsultas.service.usuarioperfil;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.UsuarioPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaUsuarioPerfil;




public interface IUsuarioPerfilService extends IMantenibleService<UsuarioPerfil> {
	
	List<UsuarioPerfil> buscarTodosUsuarioPerfil();
	
	List<UsuarioPerfil> buscarPorCriteriosUsuarioPerfil(CriterioBusquedaUsuarioPerfil criterio);
	
	UsuarioPerfil registrarUsuarioPerfil(UsuarioPerfil UsuarioPerfil);
	
	UsuarioPerfil actualizarUsuarioPerfil(int idUsuarioPerfil, UsuarioPerfil UsuarioPerfil);
	
	void eliminarUsuarioPerfil(int idUsuarioPerfil);
}
