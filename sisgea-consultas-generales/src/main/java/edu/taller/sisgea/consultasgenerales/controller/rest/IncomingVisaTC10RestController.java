package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc10.IIncomingVisaTC10Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomingVisaTC10RestController {
	
	private final IIncomingVisaTC10Service incomingVisaService;
	
	public IncomingVisaTC10RestController(IIncomingVisaTC10Service incomingVisaService) {
		this.incomingVisaService = incomingVisaService;
	}
	
	@PreAuthorize("hasPermission('CON_COBRODES_VISA', '2')")
	@GetMapping("/incomings-visa-tc10s-tcr0s/pagination")
	public Pagina<CriterioBusquedaIncomingVisaTC10, IncomingVisaTC10TCR0> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingVisaTC10, IncomingVisaTC10TCR0> criterioPaginacion,
			CriterioBusquedaIncomingVisaTC10 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingVisaTC10TCR0> lista = incomingVisaService.buscaPorCriteriosTCR0PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}
