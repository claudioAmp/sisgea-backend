package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.generadorconsultas.model.Usuario;
import ob.unibanca.sicf.generadorconsultas.service.usuario.IUsuarioService;




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