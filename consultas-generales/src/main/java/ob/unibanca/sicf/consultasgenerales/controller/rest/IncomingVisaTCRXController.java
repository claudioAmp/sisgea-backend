package ob.unibanca.sicf.consultasgenerales.controller.rest;


import java.util.List;


import org.springframework.http.MediaType;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.consultasgenerales.model.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;

import ob.unibanca.sicf.consultasgenerales.model.utilitario.PaginacionUtils;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.IIncomingVisaTCRXService;


@Validated
@RestController
public class IncomingVisaTCRXController {
	private final IIncomingVisaTCRXService incomingVisaTCRXService;
	
	public IncomingVisaTCRXController(IIncomingVisaTCRXService incomingVisaTCRXService) {
		this.incomingVisaTCRXService = incomingVisaTCRXService;
	}

	@GetMapping(value = "/incomings-visa-tcr0s}")
	public List<IncomingVisaTCR0> buscarTodosIncomingVisaTCR0( CriterioPaginacion<CriterioBusquedaIncomingVisaTCR0> criterioPaginacion) {
		System.out.println("juan");
		System.out.println(incomingVisaTCRXService.buscarTodosIncomingVisaTCR0(criterioPaginacion));
		PaginacionUtils.generarPagina(
				incomingVisaTCRXService.buscarTodosIncomingVisaTCR0(criterioPaginacion), criterioPaginacion);
		
		return 
				incomingVisaTCRXService.buscarTodosIncomingVisaTCR0(criterioPaginacion);
	
	}
}
