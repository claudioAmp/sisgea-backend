package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisatTC5TCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5.IIncomingVisaService;

@Validated
@RestController
public class IncomingVisaTC5RestController {
	private final IIncomingVisaService incomingVisaService;

	public IncomingVisaTC5RestController(IIncomingVisaService incomingVisaService) {
		this.incomingVisaService = incomingVisaService;
	}

	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping(value = "/incomings-visa-tcr0s/pagination")
	public Pagina<CriterioBusquedaIncomingVisaTCR0, IncomingVisaTC5TCR0> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingVisaTCR0, IncomingVisaTC5TCR0> criterioPaginacion,
			CriterioBusquedaIncomingVisaTCR0 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		
		Page<IncomingVisaTC5TCR0> lista = incomingVisaService.buscaPorCriteriosTCR0PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize()); 

		Pagina<CriterioBusquedaIncomingVisaTCR0, IncomingVisaTC5TCR0> pagina = new Pagina<>(
				criterioPaginacion.getCriterioBusqueda(), lista);
		return pagina;
	}
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping("/incomings-visa-tcr0s")
	public IncomingVisaTC5TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR0(criterio);
	}
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping(value = "/incomings-visa-tcr1s")
	public IncomingVisaTC5TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR1(criterio);
	}
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping(value = "/incomings-visa-tcr3s")
	public IncomingVisatTC5TCR3 buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR3(criterio);
	}
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping(value = "/incomings-visa-tcr4s")
	public IncomingVisaTC5TCR4 buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR4(criterio);
	}
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping(value = "/incomings-visa-tcr5s")
	public IncomingVisaTC5TCR5 buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR5(criterio);
	}
}
