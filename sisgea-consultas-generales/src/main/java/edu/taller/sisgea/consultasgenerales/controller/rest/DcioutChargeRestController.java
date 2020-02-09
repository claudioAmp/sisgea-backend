package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;
import edu.taller.sisgea.consultasgenerales.service.dcioutdiners.IDcioutChargeService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcioutChargeRestController {
	
	private final IDcioutChargeService dcioutChargeService;
	
	public DcioutChargeRestController(IDcioutChargeService dcioutChargeService) {
		this.dcioutChargeService = dcioutChargeService;
	}
	
	@PreAuthorize("hasPermission('CON_OUTGODINERS', '2')")
	@GetMapping(value = "/dciout-charges/pagination")
	public Pagina<CriterioBusquedaDcioutCharge, DcioutCharge> buscarPorPaginas(
			Pagina<CriterioBusquedaDcioutCharge, DcioutCharge> criterioPaginacion, CriterioBusquedaDcioutCharge criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<DcioutCharge> lista = this.dcioutChargeService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_OUTGODINERS', '2')")
	@GetMapping("/dciout-charges/detalle")
	public DcioutChargeDetalle buscarDetalle(CriterioBusquedaDcioutCharge criterio) {
		return this.dcioutChargeService.buscarDetalle(criterio);
	}
	
}
