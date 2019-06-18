package ob.unibanca.sicf.generadorconsultas.service.usuario;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Usuario;


public interface IUsuarioService extends IMantenibleService<Usuario> {
	
	List<Usuario> buscarTodosUsuarios();
	
	
}
