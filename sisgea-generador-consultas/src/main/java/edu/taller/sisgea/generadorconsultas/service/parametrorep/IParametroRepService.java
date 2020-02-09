package edu.taller.sisgea.generadorconsultas.service.parametrorep;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.ParametroRep;
import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaParametroRep;

public interface IParametroRepService extends IMantenibleService<ParametroRep> {
	
	List<ParametroRep> buscarTodosParametrosRep();
	
	List<ParametroRep> buscarPorCriteriosParametroRep(CriterioBusquedaParametroRep criterio);
	
	ParametroRep registrarParametroRep(ParametroRep ParametroRep);
	
	ParametroRep actualizarParametroRep(int idParametroRep, ParametroRep ParametroRep);
	
	void eliminarParametroRep(int idParametroRep);
	
}
