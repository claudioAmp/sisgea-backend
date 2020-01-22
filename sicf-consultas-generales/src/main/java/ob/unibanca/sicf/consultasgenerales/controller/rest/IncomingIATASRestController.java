package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.incomingIATAS.IncomingIATAS;
import ob.unibanca.sicf.consultasgenerales.service.incomingIATAS.IIncomingIATASService;

@RestController
public class IncomingIATASRestController {
	
	private final IIncomingIATASService incomingIATASService;
	
	public IncomingIATASRestController (IIncomingIATASService incomingIATASService) {
		this.incomingIATASService = incomingIATASService;
	}
	
	@PreAuthorize("hasPermission('CON_INCOMDINERS', '2')")
	@GetMapping(value = "/iatas/pagination")
	public Pagina<CriterioBusquedaIncomingIATAS, IncomingIATAS> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingIATAS,IncomingIATAS> criterioPaginacion, CriterioBusquedaIncomingIATAS criterioBusqueda){
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingIATAS> lista = this.incomingIATASService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(),lista);
	}
	
}
