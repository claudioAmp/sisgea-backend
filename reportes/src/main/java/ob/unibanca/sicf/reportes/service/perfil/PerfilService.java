package ob.unibanca.sicf.reportes.service.perfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.reportes.model.Perfil;

@Service
public class PerfilService extends MantenibleService<Perfil> implements IPerfilService {
	
	public PerfilService(@Qualifier("IPerfilMapper") IMantenibleMapper<Perfil> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Perfil> buscarTodosPerfiles() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Perfil registrarPerfil(Perfil Perfil) {
		this.registrar(Perfil);
		return Perfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Perfil actualizarPerfil(int idPerfil, Perfil Perfil) {
		Perfil.setIdPerfil(idPerfil);
		this.actualizar(Perfil);
		return Perfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPerfil(int idPerfil) {
		Perfil perfil = Perfil.builder().idPerfil(idPerfil).build();
		this.eliminar(perfil);
	}
}

