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
import ob.unibanca.sicf.generadorconsultas.model.Tabla;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTabla;
import ob.unibanca.sicf.generadorconsultas.service.tabla.ITablaService;




@Validated
@RestController
public class TablaRestController {
	
	private final ITablaService tablaService;
	
	public TablaRestController(ITablaService tablaService) {
		this.tablaService = tablaService;
	}
	
	@GetMapping(value = "/tabla")
	public List<Tabla> buscarTodosPermisosUsuario() {
		return this.tablaService.buscarTodosTabla();
	}
	@GetMapping(value = "/tabla/buscar")
	public List<Tabla> buscarTodosPermisosUsuario(CriterioBusquedaTabla criterio) {
		return this.tablaService.buscarPorCriteriosTabla(criterio);
	}
	@PostMapping(value = "/tabla", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tabla registrarTabla(@Validated({IRegistro.class, Default.class}) @RequestBody Tabla tabla) {
		return this.tablaService.registrarTabla(tabla);
	}
	
	@PutMapping(value = "/tabla/{idTabla}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Tabla actualizarTabla(@IdNumerico(maxRange = 99) @PathVariable int idTabla,
	                             @Validated @RequestBody Tabla tabla) {
		return this.tablaService.actualizarTabla(idTabla, tabla);
	}
	
	@DeleteMapping(value = "/tabla/{idTabla}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTabla(@IdNumerico(maxRange = 99) @PathVariable int idTabla) {
		this.tablaService.eliminarTabla(idTabla);
	}
}