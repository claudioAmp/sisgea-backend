package ob.unibanca.sicf.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import ob.unibanca.sicf.consultasgenerales.service.swdmplog.ISwdmplogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SwdmplogRestController {
	
	private final ISwdmplogService swdmplogService;
	
	public SwdmplogRestController(ISwdmplogService swdmplogService) {
		this.swdmplogService = swdmplogService;
	}
	
	@GetMapping("/txns-swdmplog")
	public List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterio) {
		return this.swdmplogService.buscarPorCriterios(criterio);
	}
	
	@GetMapping("/txns-swdmplog/detalle")
	public TxnSwdmplogDetalle buscarDetalleSwdmplog(CriterioBusquedaSwdmplog criterio) {
		return this.swdmplogService.buscarDetalle(criterio);
	}
	
	@GetMapping("/txns-swdmplog/pagination")
	public Pagina<CriterioBusquedaSwdmplog, TxnSwdmplog> buscarPorPaginas(
			Pagina<CriterioBusquedaSwdmplog, TxnSwdmplog> criterioPaginacion,
			CriterioBusquedaSwdmplog criterioBusqueda) {
		criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
		Page<TxnSwdmplog> lista = swdmplogService.buscarPaginada(criterioPaginacion.getCriterioBusqueda(),
				criterioPaginacion.getPageNum(), criterioPaginacion.getPageSize());
		return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
	}
}
