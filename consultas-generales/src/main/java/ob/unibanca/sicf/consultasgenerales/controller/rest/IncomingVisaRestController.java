package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
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

	/* Paginacion */

	@GetMapping(value = "/incomings-visa-tcr0s/pagination")
	public Pagina<CriterioBusquedaIncomingVisaTCR0, IncomingVisaTCR0> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingVisaTCR0, IncomingVisaTCR0> criterioPaginacion,
			CriterioBusquedaIncomingVisaTCR0 criterioBusqueda) {

		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingVisaTCR0> lista = incomingVisaService.buscaPorCriteriosTCR0PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());

		Pagina<CriterioBusquedaIncomingVisaTCR0, IncomingVisaTCR0> pagina = new Pagina<>(
				criterioPaginacion.getCriterioBusqueda(), lista);
		return pagina;
	}

	@GetMapping("/incomings-visa-tcr0s")
	public IncomingVisaTCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR0(criterio);
	}

	@GetMapping(value = "/incomings-visa-tcr1s")
	public IncomingVisaTCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR1(criterio);
	}

	@GetMapping(value = "/incomings-visa-tcr3s")
	public IncomingVisaTCR3 buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR3(criterio);
	}

	@GetMapping(value = "/incomings-visa-tcr4s")
	public IncomingVisaTCR4 buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR4(criterio);
	}

	@GetMapping(value = "/incomings-visa-tcr5s")
	public IncomingVisaTCR5 buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR5(criterio);
	}
}
