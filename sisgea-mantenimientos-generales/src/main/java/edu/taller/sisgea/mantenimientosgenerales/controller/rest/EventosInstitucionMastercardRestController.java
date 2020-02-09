package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import edu.taller.sisgea.mantenimientosgenerales.service.eventosinstitucionmastercard.IEventosInstitucionMastercardService;
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

import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosInstitucionMastercard;

@Validated
@RestController
public class EventosInstitucionMastercardRestController {
	
	private final IEventosInstitucionMastercardService eventosInstitucionMastercardService;
	
	public EventosInstitucionMastercardRestController(IEventosInstitucionMastercardService eventosInstitucionMastercardService) {
		this.eventosInstitucionMastercardService = eventosInstitucionMastercardService;
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '2')")
	@GetMapping(value = "/eventos-institucion-mastercard")
	public List<EventosInstitucionMastercard> buscarTodosEventosInstitucionMastercard() {
		return this.eventosInstitucionMastercardService.buscarTodosEventosInstitucionMastercard();
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '2')")
	@GetMapping(value = "/eventos-institucion-mastercard/{idInstitucion}")
	public List<EventosInstitucionMastercard> buscarPorInstEventosInstitucionMastercard(@PathVariable Integer idInstitucion) {
		return this.eventosInstitucionMastercardService.buscarPorInstEventosInstitucionMastercard(idInstitucion);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '1')")
	@PostMapping(value = "/eventos-institucion-mastercard", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<EventosInstitucionMastercard> registrarEventosInstitucionMastercard(@Validated({IRegistro.class, Default.class}) @RequestBody EventosInstitucionMastercard canal) {
		return this.eventosInstitucionMastercardService.registrarEventosInstitucionMastercard(canal);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '3')")
	@PutMapping(value = "/eventos-institucion-mastercard", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<EventosInstitucionMastercard> actualizarEventosInstitucionMastercard(@Validated @RequestBody EventosInstitucionMastercard eventosInstitucionMastercard) {
		return this.eventosInstitucionMastercardService.actualizarEventosInstitucionMastercard(eventosInstitucionMastercard);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '4')")
	@DeleteMapping(value = "/eventos-institucion-mastercard")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarEventosInstitucionMastercard(@Validated @RequestBody EventosInstitucionMastercard eventosInstitucionMastercard) {
		this.eventosInstitucionMastercardService.eliminarEventosInstitucionMastercard(eventosInstitucionMastercard);
	}
}
