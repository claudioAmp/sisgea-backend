package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.incomingIATA.IncomingIATA;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.service.incomingIATA.IIncomingIATAService;

@Validated
@RestController
public class IncomingIATARestController {
	
	private final IIncomingIATAService IncomingIATAService;
	
	public IncomingIATARestController (IIncomingIATAService IncomingIATAService){
		this.IncomingIATAService = IncomingIATAService;
	}
	
	
	@PreAuthorize("hasPermission('CON_INCOMDINERS', '2')")
	@GetMapping(value = "/incomingIATA")
	public List<IncomingIATA> buscarTodosBINs() {
		return this.IncomingIATAService.buscarTodosIncomingIATA();
	}
	 

	@PreAuthorize("hasPermission('CON_INCOMDINERS', '2')")
	@GetMapping(value = "/incomingIATA/pagination")
	public Pagina<CriterioBusquedaIncomingIATA, IncomingIATA> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingIATA, IncomingIATA> criterioPaginacion, CriterioBusquedaIncomingIATA criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingIATA> lista = this.IncomingIATAService.buscarPorCriterios(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize()	);
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
	
}
