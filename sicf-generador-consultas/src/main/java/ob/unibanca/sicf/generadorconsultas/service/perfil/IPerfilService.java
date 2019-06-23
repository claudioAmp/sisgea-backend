package ob.unibanca.sicf.generadorconsultas.service.perfil;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Perfil;

public interface IPerfilService extends IMantenibleService<Perfil> {
	
	List<Perfil> buscarTodosPerfiles();
	
	Perfil registrarPerfil(Perfil perfil);
	
	Perfil actualizarPerfil(int idPerfil, Perfil perfil);
	
	void eliminarPerfil(int idPerfil);
	
}
