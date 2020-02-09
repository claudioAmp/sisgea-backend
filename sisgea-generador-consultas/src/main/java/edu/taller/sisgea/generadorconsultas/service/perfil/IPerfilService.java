package edu.taller.sisgea.generadorconsultas.service.perfil;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Perfil;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface IPerfilService extends IMantenibleService<Perfil> {
	
	List<Perfil> buscarTodosPerfiles();
	
	Perfil registrarPerfil(Perfil perfil);
	
	Perfil actualizarPerfil(int idPerfil, Perfil perfil);
	
	void eliminarPerfil(int idPerfil);
	
}
