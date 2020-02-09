package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplog;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import edu.taller.sisgea.consultasgenerales.service.swdmplog.ISwdmplogService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SwdmplogRestController {
	
	private final ISwdmplogService swdmplogService;
	
	public SwdmplogRestController(ISwdmplogService swdmplogService) {
		this.swdmplogService = swdmplogService;
	}
	
	@PreAuthorize("hasPermission('CON_SWDMPLOG', '2')")
	@GetMapping("/txns-swdmplog")
	public List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterio) {
		return this.swdmplogService.buscarPorCriterios(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_SWDMPLOG', '2')")
	@GetMapping("/txns-swdmplog/detalle")
	public TxnSwdmplogDetalle buscarDetalleSwdmplog(CriterioBusquedaSwdmplog criterio) {
		return this.swdmplogService.buscarDetalle(criterio);
	}
	
	@PreAuthorize("hasPermission('CON_SWDMPLOG', '2')")
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
