package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.UltimoSecuencia;
import ob.unibanca.sicf.generadorconsultas.service.ultimosecuencia.IUltimoSecuenciaService;




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