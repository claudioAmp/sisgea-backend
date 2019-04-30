package ob.unibanca.sicf.generadorconsultas.service.permisousuario;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.PermisoUsuario;

public interface IPermisoUsuarioService extends IMantenibleService<PermisoUsuario> {
	
	List<PermisoUsuario> buscarTodosPermisosUsuario();
	
	PermisoUsuario registrarPermisoUsuario(PermisoUsuario permisoUsuario);
	
	PermisoUsuario actualizarPermisoUsuario(int idPermisoUsuario, PermisoUsuario permisoUsuario);
	
	void eliminarPermisoUsuario(int idPermisoUsuario);
	
}
