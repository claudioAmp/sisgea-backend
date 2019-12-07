package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC10TCR0;
import ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc10.IOutgoingVisaTC10Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutgoingVisaTC10RestController {
	
	private final IOutgoingVisaTC10Service outgoingVisaService;
	
	public OutgoingVisaTC10RestController(IOutgoingVisaTC10Service outgoingVisaService) {
		this.outgoingVisaService = outgoingVisaService;
	}
	
	@PreAuthorize("hasPermission('CON_COBRODES_VISA', '2')")
	@GetMapping("/outgoings-visa-tc10s-tcr0s/pagination")
	public Pagina<CriterioBusquedaOutgoingVisaTC10, OutgoingVisaTC10TCR0> buscarPorPaginas(
			Pagina<CriterioBusquedaOutgoingVisaTC10, OutgoingVisaTC10TCR0> criterioPaginacion,
			CriterioBusquedaOutgoingVisaTC10 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<OutgoingVisaTC10TCR0> lista = outgoingVisaService.buscaPorCriteriosTCR0PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}
