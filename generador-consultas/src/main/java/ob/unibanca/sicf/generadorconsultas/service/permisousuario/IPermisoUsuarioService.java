package ob.unibanca.sicf.generadorconsultas.service.permisousuario;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.PermisoUsuario;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaPermisoUsuario;

public interface IPermisoUsuarioService extends IMantenibleService<PermisoUsuario> {
	
	List<PermisoUsuario> buscarTodosPermisosUsuario();
	
	List<PermisoUsuario> buscarPorCriteriosPermisoUsuario(CriterioBusquedaPermisoUsuario criterio);
	
	PermisoUsuario registrarPermisoUsuario(PermisoUsuario permisoUsuario);
	
	PermisoUsuario actualizarPermisoUsuario(int idPermisoUsuario, PermisoUsuario permisoUsuario);
	
	void eliminarPermisoUsuario(int idPermisoUsuario);
	
	void actualizarPermisosUsuario(int idPerfil,String listaModificacion,String usuario);
	
}
