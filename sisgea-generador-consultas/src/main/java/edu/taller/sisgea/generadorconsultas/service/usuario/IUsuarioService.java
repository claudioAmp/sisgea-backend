package edu.taller.sisgea.generadorconsultas.service.usuario;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Usuario;
import ob.commons.mantenimiento.service.IMantenibleService;


public interface IUsuarioService extends IMantenibleService<Usuario> {
	
	List<Usuario> buscarTodosUsuarios();
	
	
}
