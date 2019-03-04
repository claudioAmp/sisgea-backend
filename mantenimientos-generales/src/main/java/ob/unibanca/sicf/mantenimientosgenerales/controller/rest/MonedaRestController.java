package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.unibanca.sicf.mantenimientosgenerales.model.Moneda;
import ob.unibanca.sicf.mantenimientosgenerales.service.moneda.IMonedaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class MonedaRestController {
	
	private final IMonedaService monedaService;
	
	public MonedaRestController(IMonedaService monedaService) {
		this.monedaService = monedaService;
	}
	
	@GetMapping("/monedas")
	public List<Moneda> buscarTodosMonedas() {
		return this.monedaService.buscarTodosMonedas();
	}
	
}
