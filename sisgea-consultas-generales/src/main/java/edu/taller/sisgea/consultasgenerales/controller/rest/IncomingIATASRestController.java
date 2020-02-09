package edu.taller.sisgea.consultasgenerales.controller.rest;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import edu.taller.sisgea.consultasgenerales.service.incomingIATAS.IIncomingIATASService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.incomingIATAS.IncomingIATAS;
import edu.taller.sisgea.consultasgenerales.service.incomingIATAS.IIncomingIATASService;

@RestController
public class IncomingIATASRestController {
	
	private final IIncomingIATASService incomingIATASService;
	
	public IncomingIATASRestController (IIncomingIATASService incomingIATASService) {
		this.incomingIATASService = incomingIATASService;
	}
	
	@PreAuthorize("hasPermission('CON_INCOMDINERS', '2')")
	@GetMapping(value = "/iatas/pagination")
	public Pagina<CriterioBusquedaIncomingIATAS, IncomingIATAS> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingIATAS,IncomingIATAS> criterioPaginacion, CriterioBusquedaIncomingIATAS criterioBusqueda){
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingIATAS> lista = this.incomingIATASService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(),lista);
	}
	
}
