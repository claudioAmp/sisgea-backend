package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.EventosVisa;
import ob.unibanca.sicf.mantenimientosgenerales.service.eventosvisa.IEventosVisaService;

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

	@PreAuthorize("hasPermission('MANT_BILLING_VISA', '2')")
	@GetMapping("/eventos-visa/idDescripcion")
	public List<EventosVisa> buscaridDescripcionEventosVisa(){
		return this.eventosVisaService.buscaridDescripcionEventosVisa();
	}
	
}
