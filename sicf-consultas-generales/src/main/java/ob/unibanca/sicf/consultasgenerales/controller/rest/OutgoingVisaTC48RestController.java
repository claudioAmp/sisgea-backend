package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR1;
import ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc48.IOutgoingVisaTC48Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutgoingVisaTC48RestController {
	
	private final IOutgoingVisaTC48Service outgoingVisaService;
	
	public OutgoingVisaTC48RestController(IOutgoingVisaTC48Service outgoingVisaService) {
		this.outgoingVisaService = outgoingVisaService;
	}
	
	@PreAuthorize("hasPermission('CON_AVISOSBASEI_OUTGOING_VISA', '2')")
	@GetMapping(value = "/outgoings-visa-tc48s/pagination")
	public Pagina<CriterioBusquedaOutgoingVisaTC48, OutgoingVisaTC48> buscarPorPaginas(
			Pagina<CriterioBusquedaOutgoingVisaTC48, OutgoingVisaTC48> criterioPaginacion,
			CriterioBusquedaOutgoingVisaTC48 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<OutgoingVisaTC48> lista = outgoingVisaService.buscaPorCriteriosPaginado(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_AVISOSBASEI_OUTGOING_VISA', '2')")
	@GetMapping("/outgoings-visa-tc48s-tcr0s")
	public OutgoingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaOutgoingVisa criterio) {
		return outgoingVisaService.buscarPorIdSecuenciaTCR0(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_AVISOSBASEI_OUTGOING_VISA', '2')")
	@GetMapping("/outgoings-visa-tc48s-tcr1s")
	public OutgoingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaOutgoingVisa criterio) {
		return outgoingVisaService.buscarPorIdSecuenciaTCR1(criterio);
	}
}
