package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.Bulkfile;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.bulkfile.IBulkfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BulkfileRestController {
	
	private final IBulkfileService bulkfileService;
	
	public BulkfileRestController(IBulkfileService bulkfileService) {
		this.bulkfileService = bulkfileService;
	}
	
	@GetMapping(value = "/bulkfiles/pagination")
	public Pagina<CriterioBusquedaBulkfile, Bulkfile> buscarPorPaginas(
			Pagina<CriterioBusquedaBulkfile, Bulkfile> criterioPaginacion, CriterioBusquedaBulkfile criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Bulkfile> lista = this.bulkfileService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@GetMapping("/bulkfiles/detalle")
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		return this.bulkfileService.buscarDetalle(criterio);
	}
}
