package ob.unibanca.sicf.consultasgenerales.controller.rest;


import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.IIncomingVisaService;


@Validated
@RestController
public class IncomingVisaRestController {
	private final IIncomingVisaService incomingVisaService;
	
	public IncomingVisaRestController(IIncomingVisaService incomingVisaService) {
		this.incomingVisaService = incomingVisaService;
	}

	
	@GetMapping(value = "/incomings-visa-tcr0s")
	public List<IncomingVisaTCR0> buscarTodosIncomingVisaTCR0(CriterioBusquedaIncomingVisaTCR0 criterios) {
				
		return incomingVisaService.buscaPorCriterios(criterios);
	
	}
}
