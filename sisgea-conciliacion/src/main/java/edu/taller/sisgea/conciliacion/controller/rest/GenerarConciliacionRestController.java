package edu.taller.sisgea.conciliacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.conciliacion.model.GenerarConciliacion;
import edu.taller.sisgea.conciliacion.service.generarconciliacion.IGenerarConciliacionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.groups.Default;

@Validated
@RestController
public class GenerarConciliacionRestController {
	
	private final IGenerarConciliacionService generarConciliacionService;
	
	public GenerarConciliacionRestController(IGenerarConciliacionService generarConciliacionService) {
		this.generarConciliacionService = generarConciliacionService;
	}
	
	@GetMapping("/generar-conciliaciones")
	public List<GenerarConciliacion> buscarTodosGenerarConciliacions() {
		return this.generarConciliacionService.buscarTodosGenerarConciliacions();
	}
	
	@GetMapping(value = "/generar-conciliaciones/{idConcTabla}")
	public GenerarConciliacion buscarPorIdConcTabla(@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		return this.generarConciliacionService.buscarPorIdConcTabla(idConcTabla);
	}
	
	
	@GetMapping(value = "/generar-conciliaciones/campos-tabla-observada")
	public List<GenerarConciliacion> buscarCamposTablaObservada() {
		return this.generarConciliacionService.buscarCamposTablaObservada();
	}
	
	@PostMapping(value = "/generar-conciliaciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public GenerarConciliacion generarConciliacion(@Validated({IRegistro.class, Default.class}) @RequestBody GenerarConciliacion generarConciliacion) {
		return this.generarConciliacionService.generarConciliacion(generarConciliacion);
	}
	
}
