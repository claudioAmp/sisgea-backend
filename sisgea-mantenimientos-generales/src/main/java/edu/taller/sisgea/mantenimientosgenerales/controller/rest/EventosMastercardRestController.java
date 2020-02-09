package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.EventosMastercard;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.mantenimientosgenerales.service.eventosmastercard.IEventosMastercardService;

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
