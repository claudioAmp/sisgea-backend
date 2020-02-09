package edu.taller.sisgea.generadorconsultas.service.perfil;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Perfil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;


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
	public Perfil registrarPerfil(Perfil perfil) {
		this.registrar(perfil);
		return perfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Perfil actualizarPerfil(int idPerfil, Perfil perfil) {
		perfil.setIdPerfil(idPerfil);
		this.actualizar(perfil);
		return perfil;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPerfil(int idPerfil) {
		Perfil perfil = Perfil.builder().idPerfil(idPerfil).build();
		this.eliminar(perfil);
	}
}

