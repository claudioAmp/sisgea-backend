package edu.taller.sisgea.conciliacion.controller.rest;

import edu.taller.sisgea.conciliacion.model.ConciliacionTablas;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.conciliacion.service.conciliaciontablas.IConciliacionTablasService;
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
public class ConciliacionTablasRestController {
	
	private final IConciliacionTablasService conciliacionTablasService;
	
	public ConciliacionTablasRestController(IConciliacionTablasService conciliacionTablasService) {
		this.conciliacionTablasService = conciliacionTablasService;
	}
	
	@GetMapping(value = "/conciliaciones-tablas")
	public List<ConciliacionTablas> buscarTodosConciliacionTablas() {
		return this.conciliacionTablasService.buscarTodosConciliacionTablas();
	}
	
	@GetMapping(value = "/conciliaciones/{idConciliacion}/conciliaciones-tablas")
	public List<ConciliacionTablas> buscarConciliacionTablasPorConciliacion(@IdNumerico(maxRange = 99) @PathVariable Integer idConciliacion) {
		return this.conciliacionTablasService.buscarConciliacionTablasPorConciliacion(idConciliacion);
	}
	
	@PostMapping(value = "/conciliaciones/{idConciliacion}/conciliaciones-tablas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ConciliacionTablas registrarConciliacionTablas(
			@IdNumerico(maxRange = 99) @PathVariable Integer idConciliacion,
			@Validated({IRegistro.class, Default.class}) @RequestBody ConciliacionTablas conciliacionTablas) {
		return this.conciliacionTablasService.registrarConciliacionTablas(idConciliacion, conciliacionTablas);
	}
	
	@PutMapping(value = "/conciliaciones/{idConciliacion}/conciliaciones-tablas/{idConcTabla}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ConciliacionTablas actualizarConciliacionTablas(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@IdNumerico(maxRange = 99) @PathVariable Integer idConciliacion,
			@Validated @RequestBody ConciliacionTablas conciliacionTablas) {
		return this.conciliacionTablasService.actualizarConciliacionTablas(idConcTabla, idConciliacion, conciliacionTablas);
	}
	
	@DeleteMapping(value = "/conciliaciones/{idConciliacion}/conciliaciones-tablas/{idConcTabla}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarConciliacionTablas(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
	       	@IdNumerico(maxRange = 99) @PathVariable Integer idConciliacion) {
		this.conciliacionTablasService.eliminarConciliacionTablas(idConcTabla, idConciliacion);
	}
}
