package ob.unibanca.sicf.generadorconsultas.service.campoperfil;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.CampoPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;




public interface ICampoPerfilService extends IMantenibleService<CampoPerfil> {
	
	List<CampoPerfil> buscarTodosCampoPerfil();
	
	List<CampoPerfil> buscarPorCriteriosCampoPerfil(CriterioBusquedaCampoPerfil criterio);
	
	CampoPerfil registrarCampoPerfil(CampoPerfil campoPerfil);
	
	CampoPerfil actualizarCampoPerfil(int idCampoPerfil, CampoPerfil CampoPerfil);
	
	void eliminarCampoPerfil(int idCampoPerfil);
	
	void actualizarCamposDePerfil(int idPerfil,String listaModificacion,String usuario);
}
