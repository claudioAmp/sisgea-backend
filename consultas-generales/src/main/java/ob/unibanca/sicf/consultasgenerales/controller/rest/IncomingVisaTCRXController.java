package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.consultasgenerales.model.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.IIncomingVisaTCRXService;


@Validated
@RestController
public class IncomingVisaTCRXController {
	private final IIncomingVisaTCRXService incomingVisaTCRXService;
	
	public IncomingVisaTCRXController(IIncomingVisaTCRXService incomingVisaTCRXService) {
		this.incomingVisaTCRXService = incomingVisaTCRXService;
	}
	
	@GetMapping(value = "/incomings-visa-tcr0s")
	public List<IncomingVisaTCR0> buscarTodosIncomingVisaTCR0() {
		System.out.println("llegue");
		return this.incomingVisaTCRXService.buscarTodosIncomingVisaTCR0();
	}
}
