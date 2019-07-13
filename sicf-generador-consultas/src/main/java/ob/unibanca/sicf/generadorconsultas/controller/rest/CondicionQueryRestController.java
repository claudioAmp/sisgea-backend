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
import ob.unibanca.sicf.generadorconsultas.model.CondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCondicionQuery;
import ob.unibanca.sicf.generadorconsultas.service.condicionquery.ICondicionQueryService;

@Validated
@RestController
public class CondicionQueryRestController {
	
	private final ICondicionQueryService condicionQueryService;
	
	public CondicionQueryRestController(ICondicionQueryService CondicionQueryService) {
		this.condicionQueryService = CondicionQueryService;
	}
	@GetMapping(value = "/condiciones-query")
	public List<CondicionQuery> buscarTodosCondicionesQuery() {
		return this.condicionQueryService.buscarTodos();
	}

	@GetMapping(value = "/condiciones-query/buscar")
	public List<CondicionQuery> buscarTodosCondicionQuerys(CriterioBusquedaCondicionQuery criterio) {
		return this.condicionQueryService.buscarPorCriteriosCondicionQuery(criterio);
	}

	@PostMapping(value = "/condiciones-query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CondicionQuery registrarCondicionQuery(@Validated({IRegistro.class, Default.class}) @RequestBody CondicionQuery CondicionQuery) {
		return this.condicionQueryService.registrarCondicionQuery(CondicionQuery);
	}
	
	@PutMapping(value = "/condiciones-query/{idCondicionQuery}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CondicionQuery actualizarCondicionQuery(@IdNumerico(minRange=0, maxRange = 99999) @PathVariable int idCondicionQuery,
	                             @Validated @RequestBody CondicionQuery CondicionQuery) {
		return this.condicionQueryService.actualizarCondicionQuery(idCondicionQuery, CondicionQuery);
	}
	
	@DeleteMapping(value = "/condiciones-query/{idCondicionQuery}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCondicionQuery(@IdNumerico(maxRange = 99999) @PathVariable int idCondicionQuery) {
		this.condicionQueryService.eliminarCondicionQuery(idCondicionQuery);
	}
}