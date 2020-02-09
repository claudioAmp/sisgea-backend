package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.mantenimientosgenerales.model.Origen;
import edu.taller.sisgea.mantenimientosgenerales.service.origen.IOrigenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class OrigenRestController {
	
	private final IOrigenService origenService;
	
	public OrigenRestController(IOrigenService origenService) {
		this.origenService = origenService;
	}
	
	@PreAuthorize("hasPermission('MANT_ORIGEN', '2')")
	@GetMapping("/origenes")
	public List<Origen> buscarTodosOrigens() {
		return this.origenService.buscarTodosOrigenes();
	}
	
	@PreAuthorize("hasPermission('MANT_ORIGEN', '1')")
	@PostMapping(value = "/origenes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Origen registrarOrigen(
			@Validated({IRegistro.class, Default.class}) @RequestBody Origen origen) {
		return this.origenService.registrarOrigen(origen);
	}
	
	@PreAuthorize("hasPermission('MANT_ORIGEN', '3')")
	@PutMapping(value = "/origenes/{idOrigen}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Origen actualizarOrigen(@IdNumerico(maxRange = 999) @PathVariable int idOrigen,
	                                       @Validated @RequestBody Origen origen) {
		return this.origenService.actualizarOrigen(idOrigen, origen);
	}
	
	@PreAuthorize("hasPermission('MANT_ORIGEN', '4')")
	@DeleteMapping("/origenes/{idOrigen}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarOrigen(@IdNumerico(maxRange = 999) @PathVariable int idOrigen) {
		this.origenService.eliminarOrigen(idOrigen);
	}
}
