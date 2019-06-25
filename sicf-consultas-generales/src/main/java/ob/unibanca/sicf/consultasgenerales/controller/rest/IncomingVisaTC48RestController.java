package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0Det;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc48.IIncomingVisaTC48Service;

@Validated
@RestController
public class IncomingVisaTC48RestController {

	private final IIncomingVisaTC48Service incomingVisaService;

	public IncomingVisaTC48RestController(IIncomingVisaTC48Service incomingVisaService) {
		this.incomingVisaService = incomingVisaService;
	}

	@GetMapping(value = "/incomings-visa-tc48s-tcr0s/pagination")
	public Pagina<CriterioBusquedaIncomingVisaTC48, IncomingVisaTC48TCR0> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingVisaTC48, IncomingVisaTC48TCR0> criterioPaginacion,
			CriterioBusquedaIncomingVisaTC48 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);

		Page<IncomingVisaTC48TCR0> lista = incomingVisaService.buscaPorCriteriosTCR0PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());

		Pagina<CriterioBusquedaIncomingVisaTC48, IncomingVisaTC48TCR0> pagina = new Pagina<>(
				criterioPaginacion.getCriterioBusqueda(), lista);
		return pagina;
	}

	@GetMapping("/incomings-visa-tc48s-tcr0s")
	public IncomingVisaTC48TCR0Det buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR0(criterio);
	}

	@GetMapping("/incomings-visa-tc48s-tcr1s")
	public IncomingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR1(criterio);
	}

}