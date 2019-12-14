package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.EventosMastercard;
import ob.unibanca.sicf.mantenimientosgenerales.service.eventosmastercard.IEventosMastercardService;

@Validated
@RestController
public class EventosMastercardRestController {
	
	private final IEventosMastercardService eventosMastercardService;
	
	public EventosMastercardRestController(IEventosMastercardService eventosMastercardService) {
		this.eventosMastercardService = eventosMastercardService;
	}
	@PreAuthorize("hasPermission('MANT_BILLING_VISA', '2')")
	@GetMapping("/eventos-mastercard")
	public List<EventosMastercard> buscarTodosEventosMastercard(){
		return this.eventosMastercardService.buscarTodosEventosMastercard();
	}
}
