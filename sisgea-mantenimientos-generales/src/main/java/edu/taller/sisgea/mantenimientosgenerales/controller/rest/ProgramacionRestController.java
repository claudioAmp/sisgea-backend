package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.model.Programacion;
import edu.taller.sisgea.mantenimientosgenerales.service.programacion.IProgramacionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class ProgramacionRestController {
	
	private final IProgramacionService programacionService;
	
	public ProgramacionRestController(IProgramacionService programacionService) {
		this.programacionService = programacionService;
	}
	
	@GetMapping(value = "/programaciones")
	public List<Programacion> buscarTodosProgramaciones() {
		return this.programacionService.buscarTodosProgramacion();
	}
	
}
