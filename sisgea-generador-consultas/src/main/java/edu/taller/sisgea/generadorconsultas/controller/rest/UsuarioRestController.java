package edu.taller.sisgea.generadorconsultas.controller.rest;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.Usuario;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.generadorconsultas.service.usuario.IUsuarioService;




@Validated
@RestController
public class UsuarioRestController {
	
	private final IUsuarioService usuarioService;
	
	public UsuarioRestController(IUsuarioService UsuarioService) {
		this.usuarioService = UsuarioService;
	}
	
	@GetMapping(value = "/usuarios")
	public List<Usuario> buscarTodosUsuarios() {
		return this.usuarioService.buscarTodosUsuarios();
	}
}