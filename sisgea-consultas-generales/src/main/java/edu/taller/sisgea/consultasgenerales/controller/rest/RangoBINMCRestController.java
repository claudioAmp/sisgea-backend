package edu.taller.sisgea.consultasgenerales.controller.rest;

import java.util.List;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.criterio.rangobinmc.CriterioBusquedaRangoBINMC;
import edu.taller.sisgea.consultasgenerales.model.rangobinmc.RangoBINMC;
import edu.taller.sisgea.consultasgenerales.service.rangobinmc.IRangoBINMCService;

@Validated
@RestController
public class RangoBINMCRestController {
private final IRangoBINMCService rangoBINMCService;
	
	public RangoBINMCRestController (IRangoBINMCService rangoBINMCService){
		this.rangoBINMCService = rangoBINMCService;
	}
	
	
	@PreAuthorize("hasPermission('CON_BIN_MC', '2')")
	@GetMapping(value = "/rangoBinesMC")
	public List<RangoBINMC> buscarTodosBINs() {
		return this.rangoBINMCService.buscarTodosRangoBINMC();
	}

	@PreAuthorize("hasPermission('CON_BIN_MC', '2')")
	@GetMapping(value = "/rangoBinesMC/pagination")
	public Pagina<CriterioBusquedaRangoBINMC, RangoBINMC> buscarPorPaginas(
			Pagina<CriterioBusquedaRangoBINMC, RangoBINMC> criterioPaginacion, CriterioBusquedaRangoBINMC criterioBusqueda) {
		
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<RangoBINMC> lista = this.rangoBINMCService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(),criterioPaginacion.getPageSize());
		
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}
