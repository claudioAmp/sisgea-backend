package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.criterio.pmp.CriterioBusquedaPMP;
import ob.unibanca.sicf.consultasgenerales.model.pmp.PMP;
import ob.unibanca.sicf.consultasgenerales.service.pmp.IPMPService;

@Validated
@RestController
public class PMPRestController {

	private final IPMPService pmpService;
	
	public PMPRestController(IPMPService pmpService) {
		this.pmpService = pmpService;
	}
	
	//@PreAuthorize("hasPermission('CON_PMP', '2')")
	@GetMapping("/pmp")
	public List<PMP> buscarTodos() {
		return this.pmpService.buscarTodosPMP();
	}
	
	//@PreAuthorize("hasPermission('CON_PMP', '2')")
	@GetMapping("/pmp/pagination")
	public Pagina<CriterioBusquedaPMP, PMP> buscarPorPaginas(
			Pagina<CriterioBusquedaPMP, PMP> criterioPaginacion,
			CriterioBusquedaPMP criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<PMP> lista = pmpService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
}
