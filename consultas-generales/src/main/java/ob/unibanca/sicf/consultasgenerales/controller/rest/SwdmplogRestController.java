package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import ob.unibanca.sicf.consultasgenerales.service.swdmplog.ISwdmplogService;

@Validated
@RestController
public class SwdmplogRestController {

	private final ISwdmplogService swdmplogService;
	
	public SwdmplogRestController(ISwdmplogService swdmplogService) {
		this.swdmplogService = swdmplogService;
	}
	
	@GetMapping("/txns-swdmplog")
	public List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterio){
		System.out.println(criterio.getFiltros());
		return this.swdmplogService.buscarPorCriterios(criterio);
	}
	
	@GetMapping("/txns-swdmplog/{idMovTxnSwdmplog}/detalle")
	public TxnSwdmplogDetalle buscarDetalleSwdmplog(@PathVariable("idMovTxnSwdmplog") int idMovTxnSwdmplog,
	                                                @RequestParam
	                                                @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaProceso) {
		return this.swdmplogService.buscarDetallePorCriterios(idMovTxnSwdmplog, fechaProceso);
	}
	
}
