package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinChargeDetalle;
import edu.taller.sisgea.consultasgenerales.service.dcindiners.IDcinChargeService;

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
	@GetMapping(value = "/dcin-charges/pagination")
	public Pagina<CriterioBusquedaDcinCharge, DcinCharge> buscarPorPaginas(
			Pagina<CriterioBusquedaDcinCharge, DcinCharge> criterioPaginacion, CriterioBusquedaDcinCharge criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<DcinCharge> lista = this.dcinChargeService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_INCOMDINERS', '2')")
	@GetMapping("/dcin-charges/detalle")
	public DcinChargeDetalle buscarDetalle(CriterioBusquedaDcinCharge criterio) {
		return this.dcinChargeService.buscarDetalle(criterio);
	}
	
}
