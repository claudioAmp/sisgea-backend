package ob.unibanca.sicf.generadorconsultas.service.campo;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampo;


public interface ICampoService extends IMantenibleService<Campo> {
	
	List<Campo> buscarTodosCampos();
	
	Campo buscarPorId(int idCampo);
	
	List<Campo> buscarPorCriteriosCampo(CriterioBusquedaCampo criterio);
	
	List<Campo> buscarCamposPorUsuarioActivo();
	
	Campo registrarCampo(Campo Campo);
	
	Campo actualizarCampo(int idCampo, Campo Campo);
	
	void eliminarCampo(int idCampo);
	
	
}
