package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.spring.validation.validation.IdCadena;
import edu.taller.sisgea.mantenimientosgenerales.model.GiroNegocio;
import edu.taller.sisgea.mantenimientosgenerales.service.gironegocio.IGiroNegocioService;

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
