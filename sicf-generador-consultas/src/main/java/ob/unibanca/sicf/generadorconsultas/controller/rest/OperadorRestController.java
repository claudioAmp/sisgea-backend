package ob.unibanca.sicf.generadorconsultas.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.generadorconsultas.model.Operador;
import ob.unibanca.sicf.generadorconsultas.service.operador.IOperadorService;

import java.util.List;

@Validated
@RestController
public class OperadorRestController {

	private final IOperadorService operadorService;
	
	public OperadorRestController(IOperadorService operadorService) {
		this.operadorService = operadorService;
	}
	
	@GetMapping("/operadores/{tipoDato}")
	public List<Operador> buscarPorTipoDato(@PathVariable("tipoDato") String tipoDato){
		return this.operadorService.buscarOperadorPorTipoDato(tipoDato);
	}
	
}