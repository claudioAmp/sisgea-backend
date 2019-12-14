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
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosTransaccionMastercard;
import ob.unibanca.sicf.mantenimientosgenerales.service.eventostransaccionmastercard.IEventosTransaccionMastercardService;

@Validated
@RestController
public class EventosTransaccionMastercardRestController {
	
	private final IEventosTransaccionMastercardService eventosTransaccionMastercardService;
	
	public EventosTransaccionMastercardRestController(IEventosTransaccionMastercardService eventosTransaccionMastercardService) {
		this.eventosTransaccionMastercardService = eventosTransaccionMastercardService;
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '2')")
	@GetMapping(value = "/eventos-transaccion-mastercard")
	public List<EventosTransaccionMastercard> buscarTodosEventosTransaccionMastercard() {
		return this.eventosTransaccionMastercardService.buscarTodosEventosTransaccionMastercard();
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '1')")
	@PostMapping(value = "/eventos-transaccion-mastercard", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public EventosTransaccionMastercard registrarEventosTransaccionMastercard(@Validated({IRegistro.class, Default.class}) @RequestBody EventosTransaccionMastercard canal) {
		return this.eventosTransaccionMastercardService.registrarEventosTransaccionMastercard(canal);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '3')")
	@PutMapping(value = "/eventos-transaccion-mastercard", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public EventosTransaccionMastercard actualizarEventosTransaccionMastercard(@Validated @RequestBody EventosTransaccionMastercard eventosTransaccionMastercard) {
		return this.eventosTransaccionMastercardService.actualizarEventosTransaccionMastercard(eventosTransaccionMastercard);
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '4')")
	@DeleteMapping(value = "/eventos-transaccion-mastercard")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarEventosTransaccionMastercard(@Validated @RequestBody EventosTransaccionMastercard eventosTransaccionMastercard) {
		this.eventosTransaccionMastercardService.eliminarEventosTransaccionMastercard(eventosTransaccionMastercard);
	}
}
