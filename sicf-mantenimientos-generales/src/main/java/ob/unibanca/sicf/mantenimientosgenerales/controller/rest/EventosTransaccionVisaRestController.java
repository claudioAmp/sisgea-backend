package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosTransaccionVisa;
import ob.unibanca.sicf.mantenimientosgenerales.service.eventostransaccionvisa.IEventosTransaccionVisaService;

@Validated
@RestController
public class EventosTransaccionVisaRestController {
	
	private final IEventosTransaccionVisaService eventosTransaccionVisaService;
	
	public EventosTransaccionVisaRestController(IEventosTransaccionVisaService eventosTransaccionVisaService) {
		this.eventosTransaccionVisaService = eventosTransaccionVisaService;
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '2')")
	@GetMapping(value = "/eventos-transaccion-visa")
	public List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisa() {
		return this.eventosTransaccionVisaService.buscarTodosEventosTransaccionVisa();
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '1')")
	@PostMapping(value = "/eventos-transaccion-visa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public EventosTransaccionVisa registrarEventosTransaccionVisa(@Validated({IRegistro.class, Default.class}) @RequestBody EventosTransaccionVisa canal) {
		return this.eventosTransaccionVisaService.registrarEventosTransaccionVisa(canal);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '3')")
	@PutMapping(value = "/eventos-transaccion-visa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public EventosTransaccionVisa actualizarEventosTransaccionVisa(@Validated @RequestBody EventosTransaccionVisa eventosTransaccionVisa) {
		return this.eventosTransaccionVisaService.actualizarEventosTransaccionVisa(eventosTransaccionVisa);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '4')")
	@DeleteMapping(value = "/eventos-transaccion-visa")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarEventosTransaccionVisa(@Validated @RequestBody EventosTransaccionVisa eventosTransaccionVisa) {
		this.eventosTransaccionVisaService.eliminarEventosTransaccionVisa(eventosTransaccionVisa);
	}
}
