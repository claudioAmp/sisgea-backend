package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc10.IIncomingVisaTC10Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomingVisaTC10RestController {
	
	private final IIncomingVisaTC10Service incomingVisaService;
	
	public IncomingVisaTC10RestController(IIncomingVisaTC10Service incomingVisaService) {
		this.incomingVisaService = incomingVisaService;
	}
	
	@GetMapping("/incomings-visa-tc10s-tcr0s/pagination")
	public Pagina<CriterioBusquedaIncomingVisaTC10, IncomingVisaTC10TCR0> buscarPorPaginas(
			Pagina<CriterioBusquedaIncomingVisaTC10, IncomingVisaTC10TCR0> criterioPaginacion,
			CriterioBusquedaIncomingVisaTC10 criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<IncomingVisaTC10TCR0> lista = incomingVisaService.buscaPorCriteriosTCR0PorPagina(
				criterioPaginacion.getCriterioBusqueda(), criterioPaginacion.getPageNum(),
				criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}
