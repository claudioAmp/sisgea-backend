package edu.taller.sisgea.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import edu.taller.sisgea.generadorconsultas.model.UsuarioPerfil;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaUsuarioPerfil;
import edu.taller.sisgea.generadorconsultas.service.usuarioperfil.IUsuarioPerfilService;
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
	public UsuarioPerfil actualizarUsuarioPerfil(@IdNumerico(maxRange = 9999) @PathVariable int idPerfilRepUsuario,
	                             @Validated @RequestBody UsuarioPerfil UsuarioPerfil) {
		return this.usuarioPerfilService.actualizarUsuarioPerfil(idPerfilRepUsuario, UsuarioPerfil);
	}
	
	@DeleteMapping(value = "/usuarios-perfil/{idPerfilRepUsuario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarUsuarioPerfil(@IdNumerico(maxRange = 9999) @PathVariable int idPerfilRepUsuario) {
		this.usuarioPerfilService.eliminarUsuarioPerfil(idPerfilRepUsuario);
	}
	
	@PutMapping(value = "/usuarios-perfil/{idPerfil}/{listaModificacion}/{usuario}")
	public void actualizarPerfilesUsuario(@IdNumerico(maxRange = 9999) @PathVariable int idPerfil,
			 @PathVariable  String listaModificacion,  @PathVariable String usuario) {
		System.out.println(idPerfil);
		System.out.println(listaModificacion);
		this.usuarioPerfilService.actualizarPefilesUsuario(idPerfil, listaModificacion, usuario);
	}
	
}
