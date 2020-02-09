package edu.taller.sisgea.generadorconsultas.service.permisousuario;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.PermisoUsuario;
import edu.taller.sisgea.generadorconsultas.model.Tabla;
import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaPermisoUsuario;

public interface IPermisoUsuarioService extends IMantenibleService<PermisoUsuario> {
	
	List<PermisoUsuario> buscarTodosPermisosUsuario();
	
	List<PermisoUsuario> buscarPorCriteriosPermisoUsuario(CriterioBusquedaPermisoUsuario criterio);
	
	PermisoUsuario registrarPermisoUsuario(PermisoUsuario permisoUsuario);
	
	PermisoUsuario actualizarPermisoUsuario(int idPermisoUsuario, PermisoUsuario permisoUsuario);
	
	void eliminarPermisoUsuario(int idPermisoUsuario);
	
	void actualizarPermisosUsuario(int idPerfil,String listaModificacion,String usuario);
	
	List<Tabla> buscarTablasPermitidasUsuario();
}
