package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

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

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosInstitucionVisa;
import ob.unibanca.sicf.mantenimientosgenerales.service.eventosinstitucionvisa.IEventosInstitucionVisaService;

@Validated
@RestController
public class EventosInstitucionVisaRestController {
	
	private final IEventosInstitucionVisaService eventosInstitucionVisaService;
	
	public EventosInstitucionVisaRestController(IEventosInstitucionVisaService eventosInstitucionVisaService) {
		this.eventosInstitucionVisaService = eventosInstitucionVisaService;
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '2')")
	@GetMapping(value = "/eventos-institucion-visa")
	public List<EventosInstitucionVisa> buscarTodosEventosInstitucionVisa() {
		return this.eventosInstitucionVisaService.buscarTodosEventosInstitucionVisa();
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '2')")
	@GetMapping(value = "/eventos-institucion-visa/{idInstitucion}")
	public List<EventosInstitucionVisa> buscarPorInstEventosInstitucionVisa(@PathVariable Integer idInstitucion) {
		return this.eventosInstitucionVisaService.buscarPorInstEventosInstitucionVisa(idInstitucion);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '1')")
	@PostMapping(value = "/eventos-institucion-visa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public EventosInstitucionVisa registrarEventosInstitucionVisa(@Validated({IRegistro.class, Default.class}) @RequestBody EventosInstitucionVisa canal) {
		return this.eventosInstitucionVisaService.registrarEventosInstitucionVisa(canal);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '3')")
	@PutMapping(value = "/eventos-institucion-visa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public EventosInstitucionVisa actualizarEventosInstitucionVisa(@Validated @RequestBody EventosInstitucionVisa eventosInstitucionVisa) {
		return this.eventosInstitucionVisaService.actualizarEventosInstitucionVisa(eventosInstitucionVisa);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_INST_VISA', '4')")
	@DeleteMapping(value = "/eventos-institucion-visa")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarEventosInstitucionVisa(@Validated @RequestBody EventosInstitucionVisa eventosInstitucionVisa) {
		this.eventosInstitucionVisaService.eliminarEventosInstitucionVisa(eventosInstitucionVisa);
	}
}
