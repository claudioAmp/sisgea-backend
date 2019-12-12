package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinvisa.CriterioBusquedaRangoBinVisa;
import ob.unibanca.sicf.consultasgenerales.model.rangobinvisa.RangoBINVisa;
import ob.unibanca.sicf.consultasgenerales.service.rangobinvisa.IRangoBINVisaService;

@Validated
@RestController
public class RangoBINVisaRestController {
	
	private final IRangoBINVisaService rangoBinVisaService;
	
	public RangoBINVisaRestController (IRangoBINVisaService rangoBinVisaService){
		this.rangoBinVisaService = rangoBinVisaService;
	}
	
	
	@PreAuthorize("hasPermission('CON_BIN_VISA', '2')")
	@GetMapping(value = "/rangoBinesVISA")
	public List<RangoBINVisa> buscarTodosBINs() {
		return this.rangoBinVisaService.buscarTodosRangoBINVisa();
	}

	@PreAuthorize("hasPermission('CON_BIN_VISA', '2')")
	@GetMapping(value = "/rangoBinesVISA/pagination")
	public Pagina<CriterioBusquedaRangoBinVisa, RangoBINVisa> buscarPorPaginas(
			Pagina<CriterioBusquedaRangoBinVisa, RangoBINVisa> criterioPaginacion, CriterioBusquedaRangoBinVisa criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<RangoBINVisa> lista = this.rangoBinVisaService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
}
