package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.model.Plan;
import edu.taller.sisgea.mantenimientosgenerales.service.plan.IPlanService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class PlanRestController {
	
	private final IPlanService planService;
	
	public PlanRestController(IPlanService planService) {
		this.planService = planService;
	}
	
	@GetMapping(value = "/planes")
	public List<Plan> buscarTodosPlanes() {
		return this.planService.buscarTodosPlan();
	}
	
}
