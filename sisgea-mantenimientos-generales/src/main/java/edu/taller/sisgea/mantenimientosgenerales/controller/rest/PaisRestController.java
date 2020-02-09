package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.mantenimientosgenerales.model.Pais;
import edu.taller.sisgea.mantenimientosgenerales.service.pais.IPaisService;

@RestController
public class PaisRestController {
	
	private final IPaisService paisService;
	
	public PaisRestController(IPaisService paisService) {
		this.paisService = paisService;
	}
	//@PreAuthorize("hasPermission('MANT_PAIS', '2')")
	@GetMapping("/paises")
	public List<Pais> buscarTodosPaises() {
		return this.paisService.buscarTodosPaises();
	}
	
}
