package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.Bulkfile;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
import ob.unibanca.sicf.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.dcindiners.DcinCharge;
import ob.unibanca.sicf.consultasgenerales.service.bulkfile.IBulkfileService;
import ob.unibanca.sicf.consultasgenerales.service.dcindiners.IDcinChargeService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcinChargeRestController {
	
	private final IDcinChargeService dcinChargeService;
	
	public DcinChargeRestController(IDcinChargeService dcinChargeService) {
		this.dcinChargeService = dcinChargeService;
	}
	
	@PreAuthorize("hasPermission('CON_INCOMDINERS', '2')")
	@GetMapping(value = "/dcin-charge/pagination")
	public Pagina<CriterioBusquedaDcinCharge, DcinCharge> buscarPorPaginas(
			Pagina<CriterioBusquedaDcinCharge, DcinCharge> criterioPaginacion, CriterioBusquedaDcinCharge criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<DcinCharge> lista = this.dcinChargeService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	/*
	@PreAuthorize("hasPermission('CON_BULKFILEMC', '2')")
	@GetMapping("/bulkfiles/detalle")
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		return this.bulkfileService.buscarDetalle(criterio);
	}*/
}
