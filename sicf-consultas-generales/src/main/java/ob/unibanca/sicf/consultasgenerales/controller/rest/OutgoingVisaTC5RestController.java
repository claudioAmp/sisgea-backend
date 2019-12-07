package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5.IIncomingVisaTC5Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutgoingVisaTC5RestController {
	
	private final IIncomingVisaTC5Service incomingVisaTC5Service;
	
	public OutgoingVisaTC5RestController(IIncomingVisaTC5Service incomingVisaTC5Service) {
		this.incomingVisaTC5Service = incomingVisaTC5Service;
	}
	
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping("/incomings-visa-tc5s/pagination")
	public Pagina<CriterioBusquedaIncomingVisaTC5, IncomingVisaTC5> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingVisaTC5, IncomingVisaTC5> criterioPaginacion,
			CriterioBusquedaIncomingVisaTC5 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingVisaTC5> lista = incomingVisaTC5Service.buscaPorCriteriosTC5PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping("/incomings-visa-tc5s-tcr0s")
	public IncomingVisaTC5TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaTC5Service.buscarPorIdSecuenciaTC5TCR0(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping("/incomings-visa-tc5s-tcr1s")
	public IncomingVisaTC5TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaTC5Service.buscarPorIdSecuenciaTC5TCR1(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping("/incomings-visa-tc5s-tcr3s")
	public IncomingVisaTC5TCR3 buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaTC5Service.buscarPorIdSecuenciaTC5TCR3(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping(value = "/incomings-visa-tc5s-tcr4s")
	public IncomingVisaTC5TCR4 buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaTC5Service.buscarPorIdSecuenciaTC5TCR4(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_INCOMVISA', '2')")
	@GetMapping("/incomings-visa-tc5s-tcr5s")
	public IncomingVisaTC5TCR5 buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaTC5Service.buscarPorIdSecuenciaTC5TCR5(criterio);
	}
}
