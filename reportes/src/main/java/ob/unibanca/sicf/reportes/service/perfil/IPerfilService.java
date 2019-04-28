package ob.unibanca.sicf.reportes.service.perfil;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.reportes.model.Perfil;

public interface IPerfilService extends IMantenibleService<Perfil> {
	
	List<Perfil> buscarTodosPerfiles();
	
	Perfil registrarPerfil(Perfil Perfil);
	
	Perfil actualizarPerfil(int idPerfil, Perfil Perfil);
	
	void eliminarPerfil(int idPerfil);
	
}
