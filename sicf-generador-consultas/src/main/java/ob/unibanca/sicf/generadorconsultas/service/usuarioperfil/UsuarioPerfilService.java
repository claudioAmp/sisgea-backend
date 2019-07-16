package ob.unibanca.sicf.generadorconsultas.service.usuarioperfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IUsuarioPerfilMapper;
import ob.unibanca.sicf.generadorconsultas.model.UsuarioPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaUsuarioPerfil;



@Service
public class UsuarioPerfilService extends MantenibleService<UsuarioPerfil> implements IUsuarioPerfilService {
	
	private final IUsuarioPerfilMapper usuarioPerfilMapper;
	
	public UsuarioPerfilService(@Qualifier("IusuarioPerfilMapper") IMantenibleMapper<UsuarioPerfil> mantenibleMapper) {
		super(mantenibleMapper);
		this.usuarioPerfilMapper = (IUsuarioPerfilMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<UsuarioPerfil> buscarTodosUsuarioPerfil() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<UsuarioPerfil> buscarPorCriteriosUsuarioPerfil(CriterioBusquedaUsuarioPerfil criterio) {
		return this.usuarioPerfilMapper.buscarPorCriterios(criterio);
	}
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public UsuarioPerfil registrarUsuarioPerfil(UsuarioPerfil UsuarioPerfil) {
		this.registrar(UsuarioPerfil);
		return UsuarioPerfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public UsuarioPerfil actualizarUsuarioPerfil(int idPerfilRepUsuario, UsuarioPerfil UsuarioPerfil) {
		UsuarioPerfil.setIdPerfilRepUsuario(idPerfilRepUsuario);
		this.actualizar(UsuarioPerfil);
		return UsuarioPerfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarUsuarioPerfil(int idUsuarioPerfil) {
		UsuarioPerfil usuarioPerfil = UsuarioPerfil.builder().idPerfilRepUsuario(idUsuarioPerfil).build();
		this.eliminar(usuarioPerfil);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void actualizarPefilesUsuario(int idPerfil, String listaModificacion, String usuario) {
		this.usuarioPerfilMapper.actualizarPerfilesUsuario(idPerfil, listaModificacion, usuario);
		
	}
}