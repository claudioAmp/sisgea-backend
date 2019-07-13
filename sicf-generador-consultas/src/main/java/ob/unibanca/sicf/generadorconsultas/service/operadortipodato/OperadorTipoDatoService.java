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
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;


@Service
public class OperadorTipoDatoService extends MantenibleService<OperadorTipoDato> implements IOperadorTipoDatoService {
	
	private final IOperadorTipoDatoMapper OperadorTipoDatoMapper;
	public OperadorTipoDatoService(@Qualifier("IOperadorTipoDatoMapper") IMantenibleMapper<OperadorTipoDato> mantenibleMapper) {
		super(mantenibleMapper);
		this.OperadorTipoDatoMapper = (IOperadorTipoDatoMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<OperadorTipoDato> buscarTodosOperadorTipoDato() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<OperadorTipoDato> buscarPorCriterioOperadorTipoDato(CriterioBusquedaOperadorTipoDato criterio) {
		return this.OperadorTipoDatoMapper.buscarPorCriterios(criterio);
	}
	
}

