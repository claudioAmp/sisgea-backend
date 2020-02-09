package edu.taller.sisgea.generadorconsultas.service.condicionquery;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.CondicionQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.generadorconsultas.mapper.ICondicionQueryMapper;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCondicionQuery;


@Service
public class CondicionQueryService extends MantenibleService<CondicionQuery> implements ICondicionQueryService {
	
	private final ICondicionQueryMapper CondicionQueryMapper;
	public CondicionQueryService(@Qualifier("ICondicionQueryMapper") IMantenibleMapper<CondicionQuery> mantenibleMapper) {
		super(mantenibleMapper);
		this.CondicionQueryMapper = (ICondicionQueryMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CondicionQuery> buscarTodosParametrosRep() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CondicionQuery> buscarPorCriteriosCondicionQuery(CriterioBusquedaCondicionQuery criterio) {
		return this.CondicionQueryMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CondicionQuery registrarCondicionQuery(CondicionQuery condicionQuery) {
		this.registrar(condicionQuery);
		return condicionQuery;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CondicionQuery actualizarCondicionQuery(int idCondicionQuery, CondicionQuery condicionQuery) {
		condicionQuery.setIdCondicionQuery(idCondicionQuery);
		this.actualizar(condicionQuery);
		return condicionQuery;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCondicionQuery(int idCondicionQuery) {
		CondicionQuery condicionQuery = CondicionQuery.builder().idCondicionQuery(idCondicionQuery).build();
		this.eliminar(condicionQuery);
	}
}

