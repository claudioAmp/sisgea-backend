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
import ob.unibanca.sicf.generadorconsultas.model.UsuarioPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaUsuarioPerfil;
import ob.unibanca.sicf.generadorconsultas.service.usuarioperfil.IUsuarioPerfilService;



@Validated
@RestController
public class UsuarioPerfilRestController {
	
	private final IUsuarioPerfilService usuarioPerfilService;
	
	public UsuarioPerfilRestController(IUsuarioPerfilService usuarioPerfilService) {
		this.usuarioPerfilService = usuarioPerfilService;
	}
	
	@GetMapping(value = "/usuarios-perfil")
	public List<UsuarioPerfil> buscarTodosCanales() {
		return this.usuarioPerfilService.buscarTodosUsuarioPerfil();
	}
	
	@GetMapping(value = "/usuarios-perfil/buscar")
	public List<UsuarioPerfil> buscarTodosCanales(CriterioBusquedaUsuarioPerfil criterio) {
		return this.usuarioPerfilService.buscarPorCriteriosUsuarioPerfil(criterio);
	}
	

	@PostMapping(value = "/usuarios-perfil", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioPerfil registrarUsuarioPerfil(@Validated({IRegistro.class, Default.class}) @RequestBody UsuarioPerfil usuarioPerfil) {
		return this.usuarioPerfilService.registrarUsuarioPerfil(usuarioPerfil);
	}
	
	@PutMapping(value = "/usuarios-perfil/{idPerfilRepUsuario}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UsuarioPerfil actualizarUsuarioPerfil(@IdNumerico(maxRange = 99) @PathVariable int idUsuarioPerfil,
	                             @Validated @RequestBody UsuarioPerfil UsuarioPerfil) {
		return this.usuarioPerfilService.actualizarUsuarioPerfil(idUsuarioPerfil, UsuarioPerfil);
	}
	
	@DeleteMapping(value = "/usuarios-perfil/{idPerfilRepUsuario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarUsuarioPerfil(@IdNumerico(maxRange = 99) @PathVariable int idUsuarioPerfil) {
		this.usuarioPerfilService.eliminarUsuarioPerfil(idUsuarioPerfil);
	}
	
}
