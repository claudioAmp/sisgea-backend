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
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.service.tablaonjoin.ITablaOnJoinService;




@Validated
@RestController
public class TablaOnJoinRestController {
	
	private final ITablaOnJoinService tablaOnJoinService;
	
	public TablaOnJoinRestController(ITablaOnJoinService TablaOnJoinService) {
		this.tablaOnJoinService = TablaOnJoinService;
	}
	
	@GetMapping(value = "/tablas-on-join")
	public List<TablaOnJoin> buscarTodosTablaOnJoins() {
		
		return this.tablaOnJoinService.buscarTodosTablaOnJoin();
		
	}
	@GetMapping(value = "/tablas-on-join/buscar")
	public List<TablaOnJoin> buscarTodosTablaOnJoins(CriterioBusquedaTablaOnJoin criterio) {
		return this.tablaOnJoinService.buscarPorCriteriosTablaOnJoin(criterio);
	}
	@PostMapping(value = "/tablas-on-join", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TablaOnJoin registrarTablaOnJoin(@Validated({IRegistro.class, Default.class}) @RequestBody TablaOnJoin tablaOnJoin) {
		return this.tablaOnJoinService.registrarTablaOnJoin(tablaOnJoin);
	}
	
	@PutMapping(value = "/tablas-on-join/{idTablaOnJoin}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TablaOnJoin actualizarTablaOnJoin(@IdNumerico(maxRange = 99999) @PathVariable Integer idTablaOnJoin,
	                             @Validated @RequestBody TablaOnJoin tablaOnJoin) {
		return this.tablaOnJoinService.actualizarTablaOnJoin(idTablaOnJoin, tablaOnJoin);
	}
	
	@DeleteMapping(value = "/tablaOnJoins/{idTablaOnJoin}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTablaOnJoin(@IdNumerico(maxRange = 99999) @PathVariable Integer idTablaOnJoin) {
		this.tablaOnJoinService.eliminarTablaOnJoin(idTablaOnJoin);
	}
}