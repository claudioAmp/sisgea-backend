package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.liberacion.Liberacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.liberacion.ILiberacionService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiberacionRestController {
	
	private final ILiberacionService liberacionService;
	
	public LiberacionRestController(ILiberacionService liberacionService) {
		this.liberacionService = liberacionService;
	}
	
	//@PreAuthorize("hasPermission('CON_LIBERACION', '2')")
	@GetMapping(value = "/liberaciones/pagination")
	public Pagina<CriterioBusquedaLiberacion, Liberacion> buscarPorPaginas(
			Pagina<CriterioBusquedaLiberacion, Liberacion> criterioPaginacion, 
			CriterioBusquedaLiberacion criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Liberacion> lista = this.liberacionService.buscarPorCriterios(
				criterioPaginacion.getCriterioBusqueda(),criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
}
