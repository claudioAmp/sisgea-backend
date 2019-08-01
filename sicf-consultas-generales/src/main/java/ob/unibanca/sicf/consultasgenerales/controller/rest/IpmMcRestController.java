package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.ipmmc.CriterioBusquedaIpmMc;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.ipmmc.IpmMc;
import ob.unibanca.sicf.consultasgenerales.model.ipmmc.IpmMcDetalle;
import ob.unibanca.sicf.consultasgenerales.service.ipmmc.IIpmMcService;

@Validated
@RestController
public class IpmMcRestController {
	
	private final IIpmMcService ipmMcService;
	
	public IpmMcRestController(IIpmMcService ipmMcService) {
		this.ipmMcService = ipmMcService;
	}
	
	@GetMapping(value = "/ipms/pagination")
	public Pagina<CriterioBusquedaIpmMc, IpmMc> buscarPorPagionas(Pagina<CriterioBusquedaIpmMc, IpmMc> criterioPaginacion, CriterioBusquedaIpmMc criterioBusqueda){
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IpmMc> lista = ipmMcService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		Pagina<CriterioBusquedaIpmMc, IpmMc> pagina = new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
		return pagina;
	}
	
	@GetMapping("/ipms/detalle")
	public IpmMcDetalle buscarDetalle(CriterioBusquedaIpmMc criterio) {
		return ipmMcService.buscarDetalle(criterio);
	}
	
}
