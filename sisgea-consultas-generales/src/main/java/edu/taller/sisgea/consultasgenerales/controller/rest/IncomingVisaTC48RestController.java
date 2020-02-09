package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import edu.taller.sisgea.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;
import edu.taller.sisgea.consultasgenerales.service.incomingvisa.tc48.IIncomingVisaTC48Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomingVisaTC48RestController {
	
	private final IIncomingVisaTC48Service incomingVisaService;
	
	public IncomingVisaTC48RestController(IIncomingVisaTC48Service incomingVisaService) {
		this.incomingVisaService = incomingVisaService;
	}
	
	@PreAuthorize("hasPermission('CON_AVISOSBASEI_VISA', '2')")
	@GetMapping(value = "/incomings-visa-tc48s/pagination")
	public Pagina<CriterioBusquedaIncomingVisaTC48, IncomingVisaTC48> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingVisaTC48, IncomingVisaTC48> criterioPaginacion,
			CriterioBusquedaIncomingVisaTC48 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingVisaTC48> lista = incomingVisaService.buscaPorCriteriosPaginado(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_AVISOSBASEI_VISA', '2')")
	@GetMapping("/incomings-visa-tc48s-tcr0s")
	public IncomingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR0(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_AVISOSBASEI_VISA', '2')")
	@GetMapping("/incomings-visa-tc48s-tcr1s")
	public IncomingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio) {
		return incomingVisaService.buscarPorIdSecuenciaTCR1(criterio);
	}
}
