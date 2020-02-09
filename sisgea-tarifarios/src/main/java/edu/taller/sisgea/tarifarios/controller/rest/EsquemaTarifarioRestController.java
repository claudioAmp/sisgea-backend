package edu.taller.sisgea.tarifarios.controller.rest;

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
import edu.taller.sisgea.tarifarios.model.EsquemaTarifario;
import edu.taller.sisgea.tarifarios.service.esquematarifario.IEsquemaTarifarioService;

@RestController
public class EsquemaTarifarioRestController {
	
	private final IEsquemaTarifarioService esquemaTarifarioService;
	
	public EsquemaTarifarioRestController(IEsquemaTarifarioService esquemaTarifarioService) {
		this.esquemaTarifarioService = esquemaTarifarioService;
	}
	
	@GetMapping(value="/esquemas-tarifarios")
	public List<EsquemaTarifario> buscarTodosEsquemasTarifarios(){
		return this.esquemaTarifarioService.buscarTodosEsquemas();
	}
	
	@PostMapping(value="/esquemas-tarifarios", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public EsquemaTarifario registrarEsquema(@Validated({IRegistro.class, Default.class}) @RequestBody EsquemaTarifario esquemaTarifario) {
		return this.esquemaTarifarioService.registrarEsquema(esquemaTarifario);
	}
	
	@PutMapping(value = "/esquemas-tarifarios/{idEsquema}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public EsquemaTarifario actualizarEsquema(@IdNumerico(maxRange=99) @PathVariable int idEsquema,
											  @Validated @RequestBody EsquemaTarifario esquemaTarifario) {
		return this.esquemaTarifarioService.actualizarEsquema(idEsquema, esquemaTarifario);
	}
	
	@DeleteMapping(value = "/esquemas-tarifarios/{idEsquema}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarEsquema(@IdNumerico(maxRange = 99) @PathVariable int idEsquema) {
		this.esquemaTarifarioService.eliminarEsquema(idEsquema);
	}

}
