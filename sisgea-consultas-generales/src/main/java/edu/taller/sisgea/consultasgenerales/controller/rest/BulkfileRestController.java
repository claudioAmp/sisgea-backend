package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.bulkfile.Bulkfile;
import edu.taller.sisgea.consultasgenerales.model.bulkfile.BulkfileDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.service.bulkfile.IBulkfileService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BulkfileRestController {
	
	private final IBulkfileService bulkfileService;
	
	public BulkfileRestController(IBulkfileService bulkfileService) {
		this.bulkfileService = bulkfileService;
	}
	
	@PreAuthorize("hasPermission('CON_BULKFILEMC', '2')")
	@GetMapping(value = "/bulkfiles/pagination")
	public Pagina<CriterioBusquedaBulkfile, Bulkfile> buscarPorPaginas(
			Pagina<CriterioBusquedaBulkfile, Bulkfile> criterioPaginacion, CriterioBusquedaBulkfile criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Bulkfile> lista = this.bulkfileService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_BULKFILEMC', '2')")
	@GetMapping("/bulkfiles/detalle")
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		return this.bulkfileService.buscarDetalle(criterio);
	}
}
