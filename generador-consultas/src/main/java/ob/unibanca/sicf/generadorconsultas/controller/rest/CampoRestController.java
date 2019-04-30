package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.service.campo.ICampoService;




@Validated
@RestController
public class CampoRestController {
	
	private final ICampoService campoService;
	
	public CampoRestController(ICampoService campoService) {
		this.campoService = campoService;
	}
	
	@GetMapping(value = "/campos")
	public List<Campo> buscarTodosCampos() {
		return this.campoService.buscarTodosCampos();
	}
	
}