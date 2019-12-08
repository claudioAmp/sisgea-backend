package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR5;
import ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc5.IOutgoingVisaTC5Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutgoingVisaTC5RestController {
	
	private final IOutgoingVisaTC5Service outgoingVisaTC5Service;
	
	public OutgoingVisaTC5RestController(IOutgoingVisaTC5Service outgoingVisaTC5Service) {
		this.outgoingVisaTC5Service = outgoingVisaTC5Service;
	}
	
	@PreAuthorize("hasPermission('CON_OUTOMVISA', '2')")
	@GetMapping("/outgoings-visa-tc5s/pagination")
	public Pagina<CriterioBusquedaOutgoingVisaTC5, OutgoingVisaTC5> buscarPorPaginas(
			Pagina<CriterioBusquedaOutgoingVisaTC5, OutgoingVisaTC5> criterioPaginacion,
			CriterioBusquedaOutgoingVisaTC5 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<OutgoingVisaTC5> lista = outgoingVisaTC5Service.buscaPorCriteriosTC5PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_OUTOMVISA', '2')")
	@GetMapping("/outgoings-visa-tc5s-tcr0s")
	public OutgoingVisaTC5TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaOutgoingVisa criterio) {
		return outgoingVisaTC5Service.buscarPorIdSecuenciaTC5TCR0(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_OUTOMVISA', '2')")
	@GetMapping("/outgoings-visa-tc5s-tcr1s")
	public OutgoingVisaTC5TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaOutgoingVisa criterio) {
		return outgoingVisaTC5Service.buscarPorIdSecuenciaTC5TCR1(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_OUTOMVISA', '2')")
	@GetMapping("/outgoings-visa-tc5s-tcr5s")
	public OutgoingVisaTC5TCR5 buscarPorIdSecuenciaTCR5(CriterioBusquedaOutgoingVisa criterio) {
		return outgoingVisaTC5Service.buscarPorIdSecuenciaTC5TCR5(criterio);
	}
}
