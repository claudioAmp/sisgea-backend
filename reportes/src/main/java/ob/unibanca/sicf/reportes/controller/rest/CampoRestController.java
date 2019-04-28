package ob.unibanca.sicf.reportes.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.reportes.model.Campo;
import ob.unibanca.sicf.reportes.service.campo.ICampoService;



@Validated
@RestController
public class CampoRestController {
	
	private final ICampoService CampoService;
	
	public CampoRestController(ICampoService CampoService) {
		this.CampoService = CampoService;
	}
	
	@GetMapping(value = "/campos")
	public List<Campo> buscarTodosCampos() {
		return this.CampoService.buscarTodosCampos();
	}
	
}