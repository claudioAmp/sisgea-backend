package edu.taller.sisgea.generadorconsultas.service.campo;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Campo;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampo;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaConjuntoCampo;
import ob.commons.mantenimiento.service.IMantenibleService;


public interface ICampoService extends IMantenibleService<Campo> {
	
	List<Campo> buscarTodosCampos();
	
	Campo buscarPorId(int idCampo);
	
	List<Campo> buscarIdTabla(int idTabla);
	
	List<Campo> buscarPorCriteriosCampo(CriterioBusquedaCampo criterio);
	
	List<Campo> buscarConjuntoCampos(CriterioBusquedaConjuntoCampo criterio);
	
	List<Campo> buscarCamposPorUsuarioActivo();
	
	Campo registrarCampo(Campo Campo);
	
	Campo actualizarCampo(int idCampo, Campo Campo);
	
	void eliminarCampo(int idCampo);
	
	
}
