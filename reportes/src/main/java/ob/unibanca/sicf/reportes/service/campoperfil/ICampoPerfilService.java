package ob.unibanca.sicf.reportes.service.campoperfil;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.reportes.model.CampoPerfil;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaCampoPerfil;



public interface ICampoPerfilService extends IMantenibleService<CampoPerfil> {
	
	List<CampoPerfil> buscarTodosCampoPerfil();
	
	List<CampoPerfil> buscarPorCriteriosCampoPerfil(CriterioBusquedaCampoPerfil criterio);
}
