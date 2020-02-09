package edu.taller.sisgea.conciliacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.conciliacion.model.Conciliacion;
import edu.taller.sisgea.conciliacion.service.conciliacion.IConciliacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class ConciliacionRestController {
	
	private final IConciliacionService conciliacionService;
	
	public ConciliacionRestController(IConciliacionService conciliacionService) {
		this.conciliacionService = conciliacionService;
	}
	
	@GetMapping(value = "/conciliaciones")
	public List<Conciliacion> buscarTodosConciliaciones() {
		return this.conciliacionService.buscarTodosConciliaciones();
	}
	
	@GetMapping(value = "/paquetes/{idPaquete}/conciliaciones")
	public List<Conciliacion> buscarConciliacionPorPaquete(@IdNumerico(maxRange = 99) @PathVariable Integer idPaquete) {
		return this.conciliacionService.buscarConciliacionPorPaquete(idPaquete);
	}
	
	@PostMapping(value = "/paquetes/{idPaquete}/conciliaciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Conciliacion registrarConciliacion(
			@IdNumerico(maxRange = 99) @PathVariable Integer idPaquete,
			@Validated({IRegistro.class, Default.class}) @RequestBody Conciliacion conciliacion) {
		return this.conciliacionService.registrarConciliacion(idPaquete, conciliacion);
	}
	
	@PutMapping(value = "/paquetes/{idPaquete}/conciliaciones/{idConciliacion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Conciliacion actualizarConciliacion(
			@IdNumerico(maxRange = 99) @PathVariable Integer idConciliacion,
			@IdNumerico(maxRange = 99) @PathVariable Integer idPaquete,
			@Validated @RequestBody Conciliacion conciliacion) {
		return this.conciliacionService.actualizarConciliacion(idConciliacion, idPaquete, conciliacion);
	}
	
	@DeleteMapping(value = "/paquetes/{idPaquete}/conciliaciones/{idConciliacion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarConciliacion(
			@IdNumerico(maxRange = 99) @PathVariable Integer idConciliacion,
	       	@IdNumerico(maxRange = 99) @PathVariable Integer idPaquete) {
		this.conciliacionService.eliminarConciliacion(idConciliacion, idPaquete);
	}
}
