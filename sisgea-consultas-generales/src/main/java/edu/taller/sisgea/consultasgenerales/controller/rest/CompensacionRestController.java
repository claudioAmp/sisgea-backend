package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.ComisCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.Compensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.CompensacionDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.service.compensacion.ICompensacionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompensacionRestController {
	
	private final ICompensacionService compensacionService;
	
	public CompensacionRestController(ICompensacionService compensacionService) {
		this.compensacionService = compensacionService;
	}
	
	@PreAuthorize("hasPermission('CON_COMPENSACION', '2')")
	@GetMapping(value = "/compensaciones/pagination")
	public Pagina<CriterioBusquedaCompensacion, Compensacion> buscarCriterioPorPaginas(
			Pagina<CriterioBusquedaCompensacion, Compensacion> criterioPaginacion,
			CriterioBusquedaCompensacion criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Compensacion> lista = compensacionService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_COMPENSACION', '2')")
	@GetMapping("/compensaciones/detalle")
	public CompensacionDetalle buscarDetalle(CriterioBusquedaCompensacion criterio) {
		return compensacionService.buscarPorSecuencia(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_COMPENSACION', '2')")
	@GetMapping("/compensaciones/comisiones")
	public List<ComisCompensacion> buscarComisionesPorSecuencia(CriterioBusquedaCompensacion criterio) {
		return compensacionService.buscarComisionesPorSecuencia(criterio);
	}
}
