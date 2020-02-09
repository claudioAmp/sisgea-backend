package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.mantenimientosgenerales.model.OrigenArchivo;
import edu.taller.sisgea.mantenimientosgenerales.service.origenarchivo.IOrigenArchivoService;

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

import java.util.List;

import javax.validation.groups.Default;

@Validated
@RestController
public class OrigenArchivoRestController {
	
	private final IOrigenArchivoService origenArchivoService;
	
	public OrigenArchivoRestController(IOrigenArchivoService origenArchivoService) {
		this.origenArchivoService = origenArchivoService;
	}
	
	@PreAuthorize("hasPermission('MANT_ORIARC', '2')")
	@GetMapping("/origenes-archivos")
	public List<OrigenArchivo> buscarTodosOrigenArchivos() {
		return this.origenArchivoService.buscarTodosOrigenArchivo();
	}
	
	@PreAuthorize("hasPermission('MANT_ORIARC', '2')")
	@GetMapping("/origenes-archivos/buscar")
	public List<OrigenArchivo> buscarOrigenArchivoPorConciliacion(boolean concilia) {
		return this.origenArchivoService.buscarOrigenArchivoPorConciliacion(concilia);
	}
	
	@PreAuthorize("hasPermission('MANT_ORIARC','1')")
	@PostMapping(value = "/origenes-archivos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrigenArchivo registrarOrigenArchivo(@Validated({IRegistro.class, Default.class}) @RequestBody OrigenArchivo origenArchivo) {
		return this.origenArchivoService.registrarOrigenArchivo(origenArchivo);
	}
	
	@PreAuthorize("hasPermission('MANT_ORIARC', '3')")
	@PutMapping(value = "/origenes-archivos/{idOrigenArchivo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public OrigenArchivo actualizarOrigenArchivo(
			@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "[0-9]+") @PathVariable String idOrigenArchivo,
			@Validated @RequestBody OrigenArchivo origenArchivo) {
		return this.origenArchivoService.actualizarOrigenArchivo(idOrigenArchivo, origenArchivo);
	}
	
	@PreAuthorize("hasPermission('MANT_MEMBRE', '4')")
	@DeleteMapping("/origenes-archivos/{idOrigenArchivo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarOrigenArchivo(
			@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "[0-9]+") @PathVariable String idOrigenArchivo) {
		this.origenArchivoService.eliminarOrigenArchivo(idOrigenArchivo);;
	}
		
}
