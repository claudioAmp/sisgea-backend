package edu.taller.sisgea.generadorconsultas.service.campoquery;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.CampoQuery;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface ICampoQueryService extends IMantenibleService<CampoQuery> {

    public List<CampoQuery> buscarTodosCamposQuery();
    
    List<CampoQuery> buscarPorCriteriosCamposQuery(CriterioBusquedaCampoQuery criterio);
	
	CampoQuery registrarCampoQuery(CampoQuery CampoQuery);
	
	CampoQuery actualizarCampoQuery(int idCampoQuery, CampoQuery CampoQuery);
	
	void eliminarCampoQuery(int idCampoQuery);

}