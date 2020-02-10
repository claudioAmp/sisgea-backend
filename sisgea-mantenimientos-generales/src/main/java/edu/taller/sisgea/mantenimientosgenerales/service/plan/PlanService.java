package edu.taller.sisgea.mantenimientosgenerales.service.plan;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IPlanMapper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Plan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanService extends MantenibleService<Plan> implements IPlanService {
	
	private static final String PLAN_NO_ENCONTRADO = "El Plan %s no existe";
	private final IPlanMapper planMapper;
	
	public PlanService(@Qualifier("IPlanMapper") IMantenibleMapper<Plan> mantenibleMapper) {
		super(mantenibleMapper);
		this.planMapper = (IPlanMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Plan> buscarTodosPlan() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Plan buscarPlan(String idPlan) {
		return this.planMapper.buscarPlan(idPlan).orElseThrow(
				() -> new RecursoNoEncontradoException(PLAN_NO_ENCONTRADO, idPlan));
	}
	
}
