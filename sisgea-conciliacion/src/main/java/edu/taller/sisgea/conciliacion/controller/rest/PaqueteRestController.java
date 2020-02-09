package edu.taller.sisgea.conciliacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.conciliacion.model.Paquete;
import edu.taller.sisgea.conciliacion.service.paquete.IPaqueteService;
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
public class PaqueteRestController {
	
	private final IPaqueteService paqueteService;
	
	public PaqueteRestController(IPaqueteService paqueteService) {
		this.paqueteService = paqueteService;
	}
	
	@PreAuthorize("hasPermission('MANT_CNC_PAQUETE', '2')")
	@GetMapping("/paquetes")
	public List<Paquete> buscarTodosPaquetes() {
		return this.paqueteService.buscarTodosPaquetes();
	}
	
	@PreAuthorize("hasPermission('MANT_CNC_PAQUETE', '1')")
	@PostMapping(value = "/paquetes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Paquete registrarPaquete(@Validated({IRegistro.class, Default.class}) @RequestBody Paquete paquete) {
		return this.paqueteService.registrarPaquete(paquete);
	}
	
	@PreAuthorize("hasPermission('MANT_CNC_PAQUETE', '3')")
	@PutMapping(value = "/paquetes/{idPaquete}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Paquete actualizarPaquete(
			@IdNumerico(maxRange = 99) @PathVariable Integer idPaquete,
			@Validated @RequestBody Paquete paquete) {
		return this.paqueteService.actualizarPaquete(idPaquete, paquete);
	}
	
	@PreAuthorize("hasPermission('MANT_CNC_PAQUETE', '4')")
	@DeleteMapping("/paquetes/{idPaquete}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarPaquete(@IdNumerico(maxRange = 99) @PathVariable Integer idPaquete) {
		this.paqueteService.eliminarPaquete(idPaquete);
	}
}
