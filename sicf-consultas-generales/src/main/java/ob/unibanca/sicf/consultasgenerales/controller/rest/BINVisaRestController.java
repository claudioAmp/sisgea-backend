package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.binvisa.BINVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.binvisa.CriterioBusquedaBinVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.binvisa.IBINVisaService;

@Validated
@RestController
public class BINVisaRestController {
	
	private final IBINVisaService binVisaService;
	
	public BINVisaRestController (IBINVisaService binVisaService){
		this.binVisaService = binVisaService;
	}
	
	
	@PreAuthorize("hasPermission('CON_BIN_VISA', '2')")
	@GetMapping(value = "/binsVisa")
	public List<BINVisa> buscarTodosBINs() {
		return this.binVisaService.buscarTodosBINVisa();
	}
	

	@PreAuthorize("hasPermission('CON_BIN_VISA', '2')")
	@GetMapping(value = "/binsVisa/pagination")
	public Pagina<CriterioBusquedaBinVisa, BINVisa> buscarPorPaginas(
			Pagina<CriterioBusquedaBinVisa, BINVisa> criterioPaginacion, CriterioBusquedaBinVisa criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<BINVisa> lista = this.binVisaService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
}
