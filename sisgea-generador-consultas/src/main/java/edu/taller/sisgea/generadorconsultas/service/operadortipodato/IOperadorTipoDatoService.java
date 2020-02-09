package edu.taller.sisgea.generadorconsultas.service.operadortipodato;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.OperadorTipoDato;
import edu.taller.sisgea.generadorconsultas.model.OperadoresTipoDato;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;
import ob.commons.mantenimiento.service.IMantenibleService;

public interface IOperadorTipoDatoService extends IMantenibleService<OperadorTipoDato> {
	
	List<OperadorTipoDato> buscarTodosOperadorTipoDato();
	
	List<OperadorTipoDato> buscarPorCriterioOperadorTipoDato(CriterioBusquedaOperadorTipoDato criterio);
	
	List<OperadoresTipoDato> buscarPorGruposTipoDato(CriterioBusquedaOperadorTipoDato criterio);
	
}
