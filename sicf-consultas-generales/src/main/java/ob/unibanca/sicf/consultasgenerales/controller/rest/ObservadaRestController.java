package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.observada.Observada;
import ob.unibanca.sicf.consultasgenerales.model.observada.ObservadaDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.observada.CriterioBusquedaObservada;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.observada.IObservadaService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservadaRestController {
	
	private final IObservadaService observadaService;
	
	public ObservadaRestController(IObservadaService observadaService) {
		this.observadaService = observadaService;
	}
	
	//@PreAuthorize("hasPermission('CON_OBSERVADA', '2')")
	@GetMapping(value = "/observadas/pagination")
	public Pagina<CriterioBusquedaObservada, Observada> buscarPorPaginas(
			Pagina<CriterioBusquedaObservada, Observada> criterioPaginacion, 
			CriterioBusquedaObservada criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Observada> lista = this.observadaService.buscarPorCriterios(
				criterioPaginacion.getCriterioBusqueda(),criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	//@PreAuthorize("hasPermission('CON_OBSERVADA', '2')")
	@GetMapping("/observadas/detalle")
	public ObservadaDetalle buscarDetalle(CriterioBusquedaObservada criterio) {
		return this.observadaService.buscarDetalle(criterio);
	}
}
