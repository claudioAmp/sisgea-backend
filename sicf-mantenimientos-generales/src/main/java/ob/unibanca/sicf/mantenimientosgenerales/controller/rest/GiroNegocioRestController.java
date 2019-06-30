package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.validation.validation.IdCadena;
import ob.unibanca.sicf.mantenimientosgenerales.model.GiroNegocio;
import ob.unibanca.sicf.mantenimientosgenerales.service.gironegocio.IGiroNegocioService;

@Validated
@RestController
public class GiroNegocioRestController {

	private final IGiroNegocioService giroNegocioService;

	public GiroNegocioRestController(IGiroNegocioService giroNegocioService) {
		this.giroNegocioService = giroNegocioService;
	}

	@GetMapping("/giros-negocio")
	public List<GiroNegocio> buscarTodos() {
		return this.giroNegocioService.buscarTodosGiroNegocio();
	}

	@GetMapping("/giros-negocio/{idMembresia}")
	public List<GiroNegocio> buscarModosEntradasPOSPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.giroNegocioService.buscarGiroNegocioPorMembresia(idMembresia);
	}
}
