package ob.unibanca.sicf.consultasgenerales.controller.rest;


import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR5;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.IIncomingVisaService;


@Validated
@RestController
public class IncomingVisaRestController {
	private final IIncomingVisaService incomingVisaService;
	
	public IncomingVisaRestController(IIncomingVisaService incomingVisaService) {
		this.incomingVisaService = incomingVisaService;
	}

	
	@GetMapping(value = "/incomings-visa-tcr0s")
	public List<IncomingVisaTCR0> buscaPorCriteriosTCR0(CriterioBusquedaIncomingVisaTCR0 criteriosBusqueda) {
		System.out.println("AAAAAAAAAA IMPIRMIENDO INCOMING");
		System.out.println(criteriosBusqueda);
		return incomingVisaService.buscaPorCriteriosTCR0(criteriosBusqueda);
	}
	
	@GetMapping(value = "/incomings-visa-tcr1s")
	public IncomingVisaTCR1 buscarPorIdSecuenciaTCR1(
			@RequestParam ("idSecuenciaIncoming")int idSecuenciaIncoming) {
		
		return incomingVisaService.buscarPorIdSecuenciaTCR1(idSecuenciaIncoming);
	}
	
	@GetMapping(value = "/incomings-visa-tcr3s")
	public IncomingVisaTCR3 buscarPorIdSecuenciaTCR3(
			@RequestParam ("idSecuenciaIncoming")int idSecuenciaIncoming) {
		
		return incomingVisaService.buscarPorIdSecuenciaTCR3(idSecuenciaIncoming);
	}
	
	@GetMapping(value = "/incomings-visa-tcr4s")
	public IncomingVisaTCR4 buscarPorIdSecuenciaTCR4(
			@RequestParam ("idSecuenciaIncoming")int idSecuenciaIncoming) {
	
	return incomingVisaService.buscarPorIdSecuenciaTCR4(idSecuenciaIncoming);
	}
	
	@GetMapping(value = "/incomings-visa-tcr5s")
	public IncomingVisaTCR5 buscarPorIdSecuenciaTCR5(
			@RequestParam ("idSecuenciaIncoming")int idSecuenciaIncoming) {
	
	return incomingVisaService.buscarPorIdSecuenciaTCR5(idSecuenciaIncoming);
}
}
