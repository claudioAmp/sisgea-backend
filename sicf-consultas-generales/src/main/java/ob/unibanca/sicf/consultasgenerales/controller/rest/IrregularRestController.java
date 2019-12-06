package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.irregular.Irregular;
import ob.unibanca.sicf.consultasgenerales.service.irregular.IIrregularService;

@RestController
public class IrregularRestController {
	private final IIrregularService irregularService;
	
	public IrregularRestController(IIrregularService irregularService) {
		this.irregularService = irregularService;
	}
	
	@PreAuthorize("hasPermission('CON_IRREGULAR', '2')")
	@GetMapping(value = "/irregular/pagination")
	public Pagina<CriterioBusquedaIrregular, Irregular> buscarPorPaginas(
			Pagina<CriterioBusquedaIrregular, Irregular> criterioPaginacion, CriterioBusquedaIrregular criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<Irregular> lista = irregularService.buscarPorCriteriosIrregulares(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}
