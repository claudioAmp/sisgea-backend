package ob.unibanca.sicf.generadorconsultas.service.permisousuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IPermisoUsuarioMapper;
import ob.unibanca.sicf.generadorconsultas.mapper.ITablasForaneasMapper;
import ob.unibanca.sicf.generadorconsultas.model.PermisoUsuario;
import ob.unibanca.sicf.generadorconsultas.model.Tabla;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaPermisoUsuario;


@Service
public class PermisoUsuarioService extends MantenibleService<PermisoUsuario> implements IPermisoUsuarioService {
	
	private final IPermisoUsuarioMapper permisoUsuarioMapper;
	public PermisoUsuarioService(@Qualifier("IPermisoUsuarioMapper") IMantenibleMapper<PermisoUsuario> mantenibleMapper) {
		super(mantenibleMapper);
		this.permisoUsuarioMapper = (IPermisoUsuarioMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PermisoUsuario> buscarTodosPermisosUsuario() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PermisoUsuario> buscarPorCriteriosPermisoUsuario(CriterioBusquedaPermisoUsuario criterio) {
		if(criterio.getPermited()==1) {
			String usuario = UsuarioUtil.obtenerUsername() != null ? UsuarioUtil.obtenerUsername().toUpperCase() : "";
			criterio.setUsername(usuario);
		}
		return this.permisoUsuarioMapper.buscarPorCriterios(criterio);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PermisoUsuario registrarPermisoUsuario(PermisoUsuario permisoUsuario) {
		this.registrar(permisoUsuario);
		return permisoUsuario;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PermisoUsuario actualizarPermisoUsuario(int idPermisoUsuario, PermisoUsuario permisoUsuario) {
		permisoUsuario.setIdPermisoUsuario(idPermisoUsuario);
		this.actualizar(permisoUsuario);
		return permisoUsuario;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPermisoUsuario(int idPermisoUsuario) {
		PermisoUsuario permisoUsuario = PermisoUsuario.builder().idPermisoUsuario(idPermisoUsuario).build();
		this.eliminar(permisoUsuario);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void actualizarPermisosUsuario(int idPerfil, String listaModificacion, String usuario) {
		this.permisoUsuarioMapper.actualizarPermisosUsuario(idPerfil, listaModificacion, usuario);
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Tabla> buscarTablasPermitidasUsuario() {
		System.out.println("=== Debug - Reporteador === ");
		System.out.println(UsuarioUtil.obtenerUsername());
		System.out.println("=== Debug - Reporteador === ");
		String usuario = UsuarioUtil.obtenerUsername() != null ? UsuarioUtil.obtenerUsername().toUpperCase() : "";
		return this.permisoUsuarioMapper.buscarTablasPermitidasUsuario(usuario);
	}
}

