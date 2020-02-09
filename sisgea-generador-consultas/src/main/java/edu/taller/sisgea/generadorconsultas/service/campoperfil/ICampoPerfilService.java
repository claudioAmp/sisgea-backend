package edu.taller.sisgea.generadorconsultas.service.campoperfil;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.generadorconsultas.model.CampoPerfil;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaPerfilCampoActualizarMasivo;

public interface ICampoPerfilService extends IMantenibleService<CampoPerfil> {
	
	List<CampoPerfil> buscarTodosCampoPerfil();
	
	List<CampoPerfil> buscarPorCriteriosCampoPerfil(CriterioBusquedaCampoPerfil criterio);
	
	List<CampoPerfil> buscarCamposAsignables(CriterioBusquedaCampoPerfil criterio);
	
	CampoPerfil registrarCampoPerfil(CampoPerfil campoPerfil);
	
	CampoPerfil actualizarCampoPerfil(int idCampoPerfil, CampoPerfil CampoPerfil);
	
	void eliminarCampoPerfil(int idCampoPerfil);
	
	void actualizarCamposDePerfil(int idPerfil,String listaModificacion,String usuario);
	
	void actualizarCamposDePerfilMasivo(CriterioBusquedaPerfilCampoActualizarMasivo criterio);
}
