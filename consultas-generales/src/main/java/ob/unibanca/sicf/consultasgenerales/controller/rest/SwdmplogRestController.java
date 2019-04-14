package ob.unibanca.sicf.consultasgenerales.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.service.swdmplog.ISwdmplogService;

@Validated
@RestController
public class SwdmplogRestController {

	private final ISwdmplogService swdmplogService;
	
	public SwdmplogRestController(ISwdmplogService swdmplogService) {
		this.swdmplogService = swdmplogService;
	}
	
	@GetMapping("/swdmplog")
	public ResponseEntity<?> buscarPorCriterios(CriterioBusquedaSwdmplog criterio){
		return ResponseEntity.ok(this.swdmplogService.buscarPorCriterios(criterio));
	}
	
}
