package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.facturamastercard.CriterioBusquedaFacturaMasterCard;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.facturamastercard.FacturaMasterCard;
import ob.unibanca.sicf.consultasgenerales.service.facturacionmastercard.IFacturaMasterCardService;

@RestController
public class FacturaMasterCardController {

	private final IFacturaMasterCardService facturaMasterCardService;

	public FacturaMasterCardController(IFacturaMasterCardService facturaMasterCardService) {
		this.facturaMasterCardService = facturaMasterCardService;
	}
	
	@PreAuthorize("hasPermission('CON_FACT_MC_EVENTOS', '2')")
	@GetMapping(value = "/facturaciones/masterCard")
	public Pagina<CriterioBusquedaFacturaMasterCard, FacturaMasterCard> buscarCriterioPorPaginas(
			Pagina<CriterioBusquedaFacturaMasterCard, FacturaMasterCard> criterioPaginacion,
			CriterioBusquedaFacturaMasterCard criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<FacturaMasterCard> lista = facturaMasterCardService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}