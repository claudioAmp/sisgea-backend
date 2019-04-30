package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ob.unibanca.sicf.generadorconsultas.model.Tabla;
import ob.unibanca.sicf.generadorconsultas.service.tabla.ITablaService;



@Validated
@RestController
public class TablaRestController {
	
	private final ITablaService tablaService;
	
	public TablaRestController(ITablaService tablaService) {
		this.tablaService = tablaService;
	}
	
	@GetMapping(value = "/tablas")
	public List<Tabla> buscarTodosCanales() {
		return this.tablaService.buscarTodosTablas();
	}
	
	
	
}
