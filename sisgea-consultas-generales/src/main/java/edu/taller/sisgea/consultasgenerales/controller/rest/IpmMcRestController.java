package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.ipmmc.CriterioBusquedaIpmMc;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMcDetalle;
import edu.taller.sisgea.consultasgenerales.service.ipmmc.IIpmMcService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpmMcRestController {
	
	private final IIpmMcService ipmMcService;
	
	public IpmMcRestController(IIpmMcService ipmMcService) {
		this.ipmMcService = ipmMcService;
	}
	
	@PreAuthorize("hasPermission('CON_IPM_MC', '2')")
	@GetMapping(value = "/ipms/pagination")
	public Pagina<CriterioBusquedaIpmMc, IpmMc> buscarPorPaginas(
			Pagina<CriterioBusquedaIpmMc, IpmMc> criterioPaginacion, CriterioBusquedaIpmMc criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IpmMc> lista = ipmMcService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_IPM_MC', '2')")
	@GetMapping("/ipms/detalle")
	public IpmMcDetalle buscarDetalle(CriterioBusquedaIpmMc criterio) {
		return ipmMcService.buscarDetalle(criterio);
	}
}
