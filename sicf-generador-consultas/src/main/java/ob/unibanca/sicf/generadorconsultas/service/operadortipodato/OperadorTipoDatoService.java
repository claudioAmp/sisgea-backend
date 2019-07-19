package ob.unibanca.sicf.generadorconsultas.service.operadortipodato;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.IOperadorTipoDatoMapper;
import ob.unibanca.sicf.generadorconsultas.model.OperadorTipoDato;
import ob.unibanca.sicf.generadorconsultas.model.OperadoresTipoDato;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;


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

