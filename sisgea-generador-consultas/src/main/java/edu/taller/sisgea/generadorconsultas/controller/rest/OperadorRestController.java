package edu.taller.sisgea.generadorconsultas.controller.rest;

import edu.taller.sisgea.generadorconsultas.model.Operador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.generadorconsultas.service.operador.IOperadorService;

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
