package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.mantenimientosgenerales.model.EventosVisa;
import edu.taller.sisgea.mantenimientosgenerales.service.eventosvisa.IEventosVisaService;

@Validated
@RestController
public class EventosVisaRestController {
	
	private final IEventosVisaService eventosVisaService;
	
	public EventosVisaRestController(IEventosVisaService eventosVisaService) {
		this.eventosVisaService = eventosVisaService;
	}

	@PreAuthorize("hasPermission('MANT_BILLING_VISA', '2')")
	@GetMapping("/eventos-visa")
	public List<EventosVisa> buscarTodosEventosVisa(){
		return this.eventosVisaService.buscarTodosEventosVisa();
	}
	
	@PreAuthorize("hasPermission('MANT_BILLING_TXN_VISA', '2')")
	@GetMapping(value = "/eventos-visa/sinTxn")
	public List<EventosVisa> buscarTodosEventosTransaccionVisaSinTxn() {
		return this.eventosVisaService.buscarTodosEventosTransaccionVisaSinTxn();
	}

	@PreAuthorize("hasPermission('MANT_BILLING_VISA', '2')")
	@GetMapping("/eventos-visa/idDescripcion")
	public List<EventosVisa> buscaridDescripcionEventosVisa(){
		return this.eventosVisaService.buscaridDescripcionEventosVisa();
	}
	
}
