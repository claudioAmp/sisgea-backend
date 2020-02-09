package edu.taller.sisgea.generadorconsultas.controller.rest;


import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.TablasForaneas;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTablasForaneas;
import edu.taller.sisgea.generadorconsultas.service.tablaforanea.ITablasForaneasService;
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

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;


@Validated
@RestController
public class TablasForaneasRestController {
	
	private final ITablasForaneasService tablasForaneasService;
	
	public TablasForaneasRestController(ITablasForaneasService tablasForaneasService) {
		this.tablasForaneasService = tablasForaneasService;
	}
	
	@GetMapping(value = "/tablas-foraneas")
	public List<TablasForaneas> buscarTodosTablasForaneases() {
		return this.tablasForaneasService.buscarTodosTablasForaneas();
	}
	
	@GetMapping(value = "/tablas-foraneas/buscar")
	public List<TablasForaneas> buscarTodosTablasForaneases(CriterioBusquedaTablasForaneas criterio) {
		System.out.println("BUSCANDO TABLAS FORANEAS...");
		System.out.println(criterio);
		return this.tablasForaneasService.buscarPorCriteriosTablasForaneas(criterio);
	}
	
	@GetMapping(value="/tablas-foraneas/buscar/{idRelacionTablaFk}")
	public TablasForaneas buscarPorIdTablaForanea(@PathVariable int idRelacionTablaFk){
		System.out.println("BUSCANDO TABLAS FORANEAS POR ID...");
		return this.tablasForaneasService.buscarTablaForaneaPorId(idRelacionTablaFk);
	}
	
	@PostMapping(value = "/tablas-foraneas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TablasForaneas registrarTablasForaneas(@Validated({IRegistro.class, Default.class}) @RequestBody TablasForaneas tablaQuery) {
		return this.tablasForaneasService.registrarTablasForaneas(tablaQuery);
	}
	
	@PutMapping(value = "/tablas-foraneas/{idRelacionTablaFk}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TablasForaneas actualizarTablasForaneas(@IdNumerico(maxRange = 9999) @PathVariable int idRelacionTablaFk,
	                             @Validated @RequestBody TablasForaneas tablaQuery) {
		return this.tablasForaneasService.actualizarTablasForaneas(idRelacionTablaFk, tablaQuery);
	}
	
	@DeleteMapping(value = "/tablas-foraneas/{idRelacionTablaFk}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTablasForaneas(@IdNumerico(maxRange = 9999) @PathVariable int idRelacionTablaFk) {
		this.tablasForaneasService.eliminarTablasForaneas(idRelacionTablaFk);
	}

}
