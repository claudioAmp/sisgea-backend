package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

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
	
	@GetMapping(value = "/compensaciones/pagination")
	public Pagina<CriterioBusquedaCompensacion, Compensacion> buscarPorPaginas(Pagina<CriterioBusquedaCompensacion, Compensacion> criterioPaginacion, CriterioBusquedaCompensacion criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Compensacion> lista = compensacionService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),criterioPaginacion.getPageSize());
		Pagina<CriterioBusquedaCompensacion, Compensacion> pagina = new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
		return pagina;
	}

	@GetMapping("/compensaciones")
	public CompensacionDetalle buscarPorIdSecuenciaTCR0(CriterioBusquedaCompensacion criterio) {
		return compensacionService.buscarPorSecuencia(criterio);
	}
	
}
