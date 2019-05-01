package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.service.campoquery.ICampoQueryService;



@Validated
@RestController
public class CampoQueryRestController {
	
	private final ICampoQueryService campoQueryService;
	
	public CampoQueryRestController(ICampoQueryService campoQueryService) {
        this.campoQueryService = campoQueryService;
        
	}
    
    @GetMapping(value = "/campo-query")
	public List<CampoQuery> buscarTodosCampoQuery() {
		return this.campoQueryService.buscarTodosCampoQuery();
	}
	
}