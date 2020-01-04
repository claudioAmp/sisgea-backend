package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.facturavisa.CriterioBusquedaFacturaVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.facturacionvisa.IFacturaVisaService;
import ob.unibanca.sicf.facturacion.model.FacturaVisa;

@RestController
public class FacturaVisaController {

	private final IFacturaVisaService facturaVisaService;

	public FacturaVisaController(IFacturaVisaService facturaVisaService) {
		this.facturaVisaService = facturaVisaService;
	}
	
	@PreAuthorize("hasPermission('CON_FACT_VISA_EVENTOS', '2')")
	@GetMapping(value = "/facturaciones/visa")
	public Pagina<CriterioBusquedaFacturaVisa, FacturaVisa> buscarCriterioPorPaginas(
			Pagina<CriterioBusquedaFacturaVisa, FacturaVisa> criterioPaginacion,
			CriterioBusquedaFacturaVisa criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<FacturaVisa> lista = facturaVisaService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}