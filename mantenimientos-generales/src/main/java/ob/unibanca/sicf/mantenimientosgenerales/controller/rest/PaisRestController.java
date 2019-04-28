package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.Pais;
import ob.unibanca.sicf.mantenimientosgenerales.service.pais.IPaisService;

@RestController
public class PaisRestController {
	
	private final IPaisService paisService;
	
	public PaisRestController(IPaisService paisService) {
		this.paisService = paisService;
	}
	@GetMapping("/paises")
	public List<Pais> buscarTodosPaises() {
		return this.paisService.buscarTodosPaises();
	}
	
}
