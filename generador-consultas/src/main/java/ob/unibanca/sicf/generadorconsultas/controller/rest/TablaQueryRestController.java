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

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;
import ob.unibanca.sicf.generadorconsultas.service.tablaquery.*;




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
	public TablaQuery registrarTablaQuery(@Validated({IRegistro.class, Default.class}) @RequestBody TablaQuery TablaQuery) {
		return this.TablaQueryService.registrarTablaQuery(TablaQuery);
	}
	
	@PutMapping(value = "/tablas-query/{idTabla}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TablaQuery actualizarTablaQuery(@IdNumerico(maxRange = 99) @PathVariable int idTablaQuery,
	                             @Validated @RequestBody TablaQuery TablaQuery) {
		return this.TablaQueryService.actualizarTablaQuery(idTablaQuery, TablaQuery);
	}
	
	@DeleteMapping(value = "/tablas-query/{idTabla}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTablaQuery(@IdNumerico(maxRange = 99) @PathVariable int idTablaQuery) {
		this.TablaQueryService.eliminarTablaQuery(idTablaQuery);
	}
}