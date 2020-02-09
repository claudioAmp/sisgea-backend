package edu.taller.sisgea.generadorconsultas.controller.rest;

import edu.taller.sisgea.generadorconsultas.model.UltimoSecuencia;
import edu.taller.sisgea.generadorconsultas.service.ultimosecuencia.IUltimoSecuenciaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RestController
public class UltimoSecuenciaRestController {
	
	private final IUltimoSecuenciaService ultimoSecuenciaService;
	
	public UltimoSecuenciaRestController(IUltimoSecuenciaService ultimoSecuenciaService ) {
		this.ultimoSecuenciaService = ultimoSecuenciaService;
	}
	
	@GetMapping(value = "/ultimo-secuencia/{claseSecuencia}")
	public UltimoSecuencia buscarTodosUltimoSecuencias(@PathVariable String claseSecuencia) {
		return this.ultimoSecuenciaService.obtenerUltimoSecuencia(claseSecuencia);
		
	}
	
	
}