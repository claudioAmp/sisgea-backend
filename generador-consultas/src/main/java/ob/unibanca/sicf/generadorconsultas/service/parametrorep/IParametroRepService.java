package ob.unibanca.sicf.generadorconsultas.service.parametrorep;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.ParametroRep;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaParametroRep;

public interface IParametroRepService extends IMantenibleService<ParametroRep> {
	
	List<ParametroRep> buscarTodosParametrosRep();
	
	List<ParametroRep> buscarPorCriteriosParametroRep(CriterioBusquedaParametroRep criterio);
	
	ParametroRep registrarParametroRep(ParametroRep ParametroRep);
	
	ParametroRep actualizarParametroRep(int idParametroRep, ParametroRep ParametroRep);
	
	void eliminarParametroRep(int idParametroRep);
	
}
