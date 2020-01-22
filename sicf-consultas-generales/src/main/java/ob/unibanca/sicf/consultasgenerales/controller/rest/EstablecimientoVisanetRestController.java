package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanet;
import ob.unibanca.sicf.consultasgenerales.model.establecimientovisanet.EstablecimientoVisanetComis;
import ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientovisanet.CriterioBusquedaEstablecimientoVisanet;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.establecimientovisanet.IEstablecimientoVisanetService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstablecimientoVisanetRestController {
	
	private final IEstablecimientoVisanetService establecimientoVisanetService;
	
	public EstablecimientoVisanetRestController(IEstablecimientoVisanetService establecimientoVisanetService) {
		this.establecimientoVisanetService = establecimientoVisanetService;
	}
	
	@PreAuthorize("hasPermission('CON_ESTABLECIMIENTO_VISANET', '2')")
	@GetMapping(value = "/establecimientos-visanet/pagination")
	public Pagina<CriterioBusquedaEstablecimientoVisanet, EstablecimientoVisanet> buscarCriterioPorPaginas(
			Pagina<CriterioBusquedaEstablecimientoVisanet, EstablecimientoVisanet> criterioPaginacion,
			CriterioBusquedaEstablecimientoVisanet criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<EstablecimientoVisanet> lista = establecimientoVisanetService.buscarPorCriterios(
				criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
	@PreAuthorize("hasPermission('CON_ESTABLECIMIENTO_VISANET', '2')")
	@GetMapping("/establecimientos-visanet/comisiones")
	public List<EstablecimientoVisanetComis> buscarComisionesPorSecuencia(CriterioBusquedaEstablecimientoVisanet criterio) {
		return establecimientoVisanetService.buscarComisionesPorSecuencia(criterio);
	}
	
}
