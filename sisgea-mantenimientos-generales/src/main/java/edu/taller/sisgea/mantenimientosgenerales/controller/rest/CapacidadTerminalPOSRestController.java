package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.model.CapacidadTerminalPOS;
import edu.taller.sisgea.mantenimientosgenerales.service.capacidadterminalpos.ICapacidadTerminalPOSService;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;
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
public class CapacidadTerminalPOSRestController {
	
	private final ICapacidadTerminalPOSService capacidadTerminalPOSService;
	
	public CapacidadTerminalPOSRestController(ICapacidadTerminalPOSService capacidadTerminalPOSService) {
		this.capacidadTerminalPOSService = capacidadTerminalPOSService;
	}
	@PreAuthorize("hasPermission('MANT_CAPTERPOS', '2')")
	@GetMapping("/capacidades-terminales-pos")
	public List<CapacidadTerminalPOS> buscarTodosCapacidadesTerminalesPOS() {
		return this.capacidadTerminalPOSService.buscarTodosCapacidadesTerminalesPOS();
	}
	@PreAuthorize("hasPermission('MANT_CAPTERPOS', '2')")
	@GetMapping("/membresias/{idMembresia}/capacidades-terminales-pos")
	public List<CapacidadTerminalPOS> buscarCapacidadesTerminalesPOSPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.capacidadTerminalPOSService.buscarCapacidadesTerminalesPOSPorMembresia(idMembresia);
	}
	@PreAuthorize("hasPermission('MANT_CAPTERPOS', '1')")
	@PostMapping(value = "/membresias/{idMembresia}/capacidades-terminales-pos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CapacidadTerminalPOS registrarCapacidadTerminalPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@Validated({IRegistro.class, Default.class}) @RequestBody CapacidadTerminalPOS capacidadTerminalPOS) {
		return this.capacidadTerminalPOSService.registrarCapacidadTerminalPOS(idMembresia, capacidadTerminalPOS);
	}
	@PreAuthorize("hasPermission('MANT_CAPTERPOS', '3')")
	@PutMapping(value = "/membresias/{idMembresia}/capacidades-terminales-pos/{idTerminalPOS}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CapacidadTerminalPOS actualizarCapacidadTerminalPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 2, regexpPattern = "[A-Z0-9]*") @PathVariable String idTerminalPOS,
			@Validated @RequestBody CapacidadTerminalPOS capacidadTerminalPOS) {
		return this.capacidadTerminalPOSService.actualizarCapacidadTerminalPOS(idMembresia, idTerminalPOS, capacidadTerminalPOS);
	}
	@PreAuthorize("hasPermission('MANT_CAPTERPOS', '4')")
	@DeleteMapping("/membresias/{idMembresia}/capacidades-terminales-pos/{idTerminalPOS}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCapacidadTerminalPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 2, regexpPattern = "[A-Z0-9]*") @PathVariable String idTerminalPOS) {
		this.capacidadTerminalPOSService.eliminarCapacidadTerminalPOS(idMembresia, idTerminalPOS);
	}
	
}
