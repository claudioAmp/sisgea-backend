package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.mantenimientosgenerales.model.Membresia;
import edu.taller.sisgea.mantenimientosgenerales.service.membresia.IMembresiaService;
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
public class MembresiaRestController {
	
	private final IMembresiaService membresiaService;
	
	public MembresiaRestController(IMembresiaService membresiaService) {
		this.membresiaService = membresiaService;
	}
	
	@PreAuthorize("hasPermission('MANT_MEMBRE', '2')")
	@GetMapping("/membresias")
	public List<Membresia> buscarTodosMembresias() {
		return this.membresiaService.buscarTodosMembresias();
	}
	
	@PreAuthorize("hasPermission('MANT_MEMBRE', '1')")
	@PostMapping(value = "/membresias", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Membresia registrarMembresia(@Validated({IRegistro.class, Default.class}) @RequestBody Membresia membresia) {
		return this.membresiaService.registrarMembresia(membresia);
	}
	
	@PreAuthorize("hasPermission('MANT_MEMBRE', '3')")
	@PutMapping(value = "/membresias/{idMembresia}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Membresia actualizarMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@Validated @RequestBody Membresia membresia) {
		return this.membresiaService.actualizarMembresia(idMembresia, membresia);
	}
	
	@PreAuthorize("hasPermission('MANT_MEMBRE', '4')")
	@DeleteMapping("/membresias/{idMembresia}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		this.membresiaService.eliminarMembresia(idMembresia);
	}
}
