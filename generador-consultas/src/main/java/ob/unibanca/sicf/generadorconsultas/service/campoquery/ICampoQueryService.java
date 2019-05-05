package ob.unibanca.sicf.generadorconsultas.service.campoquery;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;

public interface ICampoQueryService extends IMantenibleService<CampoQuery> {

    public List<CampoQuery> buscarTodosCamposQuery();
    
    List<CampoQuery> buscarPorCriteriosCamposQuery(CriterioBusquedaCampoQuery criterio);
	
	CampoQuery registrarCampoQuery(CampoQuery CampoQuery);
	
	CampoQuery actualizarCampoQuery(int idCampoQuery, CampoQuery CampoQuery);
	
	void eliminarCampoQuery(int idCampoQuery);

}