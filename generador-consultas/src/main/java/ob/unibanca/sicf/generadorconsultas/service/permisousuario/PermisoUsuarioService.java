package ob.unibanca.sicf.generadorconsultas.service.permisousuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.PermisoUsuario;


@Service
public class PermisoUsuarioService extends MantenibleService<PermisoUsuario> implements IPermisoUsuarioService {
	
	public PermisoUsuarioService(@Qualifier("IPermisoUsuarioMapper") IMantenibleMapper<PermisoUsuario> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PermisoUsuario> buscarTodosPermisosUsuario() {
		return this.buscarTodos();
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
}

