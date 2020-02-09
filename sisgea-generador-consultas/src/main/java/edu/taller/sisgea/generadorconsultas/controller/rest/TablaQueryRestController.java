package edu.taller.sisgea.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import edu.taller.sisgea.generadorconsultas.model.TablaQuery;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;
import edu.taller.sisgea.generadorconsultas.service.tablaquery.ITablaQueryService;
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
import edu.taller.sisgea.generadorconsultas.service.tablaquery.*;




@Validated
@RestController
public class TablaQueryRestController {
	
	private final ITablaQueryService TablaQueryService;
	
	public TablaQueryRestController(ITablaQueryService TablaQueryService) {
		this.TablaQueryService = TablaQueryService;
	}
	
	@GetMapping(value = "/tablas-query")
	public List<TablaQuery> buscarTodosTablaQuerys() {
		
		return this.TablaQueryService.buscarTodosTablasQuery();
		
	}
	@GetMapping(value = "/tablas-query/buscar")
	public List<TablaQuery> buscarTodosTablaQuerys(CriterioBusquedaTablaQuery criterio) {
		return this.TablaQueryService.buscarPorCriteriosTablaQuery(criterio);
	}
	@PostMapping(value = "/tablas-query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TablaQuery registrarTablaQuery(@Validated({IRegistro.class, Default.class}) @RequestBody TablaQuery tablaQuery) {
		return this.TablaQueryService.registrarTablaQuery(tablaQuery);
	}
	
	@PutMapping(value = "/tablas-query/{idTablaQuery}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TablaQuery actualizarTablaQuery(@IdNumerico(maxRange = 9999) @PathVariable int idTablaQuery,
	                             @Validated @RequestBody TablaQuery tablaQuery) {
		return this.TablaQueryService.actualizarTablaQuery(idTablaQuery, tablaQuery);
	}
	
	@DeleteMapping(value = "/tablas-query/{idTablaQuery}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTablaQuery(@IdNumerico(maxRange = 9999) @PathVariable int idTablaQuery) {
		this.TablaQueryService.eliminarTablaQuery(idTablaQuery);
	}
}