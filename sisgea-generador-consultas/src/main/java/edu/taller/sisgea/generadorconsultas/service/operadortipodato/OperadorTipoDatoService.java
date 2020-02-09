package edu.taller.sisgea.generadorconsultas.service.operadortipodato;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.OperadorTipoDato;
import edu.taller.sisgea.generadorconsultas.model.OperadoresTipoDato;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.generadorconsultas.mapper.IOperadorTipoDatoMapper;


@Service
public class OperadorTipoDatoService extends MantenibleService<OperadorTipoDato> implements IOperadorTipoDatoService {
	
	private final IOperadorTipoDatoMapper operadorTipoDatoMapper;
	public OperadorTipoDatoService(@Qualifier("IOperadorTipoDatoMapper") IMantenibleMapper<OperadorTipoDato> mantenibleMapper) {
		super(mantenibleMapper);
		this.operadorTipoDatoMapper = (IOperadorTipoDatoMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<OperadorTipoDato> buscarTodosOperadorTipoDato() {
		return this.buscarTodos();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<OperadorTipoDato> buscarPorCriterioOperadorTipoDato(CriterioBusquedaOperadorTipoDato criterio) {
		return this.operadorTipoDatoMapper.buscarPorCriterios(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<OperadoresTipoDato> buscarPorGruposTipoDato(CriterioBusquedaOperadorTipoDato criterio){
		return this.operadorTipoDatoMapper.buscarPorGruposTipoDato(criterio);
	}
}

