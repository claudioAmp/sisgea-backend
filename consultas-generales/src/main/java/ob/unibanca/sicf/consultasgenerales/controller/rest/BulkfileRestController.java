package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.bulkfile.Bulkfile;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.bulkfile.IBulkfileService;


@Validated
@RestController
public class BulkfileRestController {
	private final IBulkfileService bulkfileService;
	
	public BulkfileRestController(IBulkfileService bulkfileService) {
		this.bulkfileService = bulkfileService;
	}
	
	@GetMapping(value = "/bulkfiles/pagination")
	public Pagina<CriterioBusquedaBulkfile, Bulkfile> buscarPorPaginas(Pagina<CriterioBusquedaBulkfile, Bulkfile> criterioPaginacion, CriterioBusquedaBulkfile criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Bulkfile> lista = bulkfileService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),criterioPaginacion.getPageSize());
		Pagina<CriterioBusquedaBulkfile, Bulkfile> pagina = new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
		return pagina;
	}

	@GetMapping("/bulkfiles/detalle")
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		return bulkfileService.buscarDetalle(criterio);
	}
	
}
