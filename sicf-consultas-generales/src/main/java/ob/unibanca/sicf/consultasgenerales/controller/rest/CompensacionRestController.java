package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.compensacion.ComisCompensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.Compensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.CompensacionDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.compensacion.ICompensacionService;

@Validated
@RestController
public class CompensacionRestController {
	private final ICompensacionService compensacionService;
	
	public CompensacionRestController(ICompensacionService compensacionService) {
		this.compensacionService = compensacionService;
	}
	
	@PreAuthorize("hasPermission('CON_COMPENSACION', '2')")
	@GetMapping(value = "/compensaciones/pagination")
	public Pagina<CriterioBusquedaCompensacion, Compensacion> buscarCriterioPorPaginas(Pagina<CriterioBusquedaCompensacion, Compensacion> criterioPaginacion, CriterioBusquedaCompensacion criterioBusqueda) {
		
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Compensacion> lista = compensacionService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),criterioPaginacion.getPageSize());
		Pagina<CriterioBusquedaCompensacion, Compensacion> pagina = new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
		
		return pagina;
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