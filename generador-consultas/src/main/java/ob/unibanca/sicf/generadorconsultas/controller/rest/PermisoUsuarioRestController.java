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
import ob.unibanca.sicf.generadorconsultas.model.PermisoUsuario;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaPermisoUsuario;
import ob.unibanca.sicf.generadorconsultas.service.permisousuario.IPermisoUsuarioService;




@Validated
@RestController
public class PermisoUsuarioRestController {
	
	private final IPermisoUsuarioService permisoUsuarioService;
	
	public PermisoUsuarioRestController(IPermisoUsuarioService permisoUsuarioService) {
		this.permisoUsuarioService = permisoUsuarioService;
	}
	
	@GetMapping(value = "/permisos-usuario")
	public List<PermisoUsuario> buscarTodosPermisosUsuario() {
		return this.permisoUsuarioService.buscarTodosPermisosUsuario();
	}
	@GetMapping(value = "/tablas-foraneas/buscar")
	public List<PermisoUsuario> buscarTodosPermisosUsuario(CriterioBusquedaPermisoUsuario criterio) {
		return this.permisoUsuarioService.buscarPorCriteriosPermisoUsuario(criterio);
	}
	@PostMapping(value = "/permisos-usuario", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public PermisoUsuario registrarPermisoUsuario(@Validated({IRegistro.class, Default.class}) @RequestBody PermisoUsuario permisoUsuario) {
		return this.permisoUsuarioService.registrarPermisoUsuario(permisoUsuario);
	}
	
	@PutMapping(value = "/permisos-usuario/{idPermisoUsuario}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PermisoUsuario actualizarPermisoUsuario(@IdNumerico(maxRange = 99) @PathVariable int idPermisoUsuario,
	                             @Validated @RequestBody PermisoUsuario permisoUsuario) {
		return this.permisoUsuarioService.actualizarPermisoUsuario(idPermisoUsuario, permisoUsuario);
	}
	
	@DeleteMapping(value = "/permisos-usuario/{idPermisoUsuario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarPermisoUsuario(@IdNumerico(maxRange = 99) @PathVariable int idPermisoUsuario) {
		this.permisoUsuarioService.eliminarPermisoUsuario(idPermisoUsuario);
	}
}