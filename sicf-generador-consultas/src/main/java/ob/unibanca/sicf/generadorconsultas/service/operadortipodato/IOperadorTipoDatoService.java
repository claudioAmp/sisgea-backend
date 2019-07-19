package ob.unibanca.sicf.generadorconsultas.service.operadortipodato;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.OperadorTipoDato;
import ob.unibanca.sicf.generadorconsultas.model.OperadoresTipoDato;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;

public interface IOperadorTipoDatoService extends IMantenibleService<OperadorTipoDato> {
	
	List<OperadorTipoDato> buscarTodosOperadorTipoDato();
	
	List<OperadorTipoDato> buscarPorCriterioOperadorTipoDato(CriterioBusquedaOperadorTipoDato criterio);
	
	List<OperadoresTipoDato> buscarPorGruposTipoDato(CriterioBusquedaOperadorTipoDato criterio);
	
}
