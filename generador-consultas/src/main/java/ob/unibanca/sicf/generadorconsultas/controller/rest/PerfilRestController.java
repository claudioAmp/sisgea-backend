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
import ob.unibanca.sicf.generadorconsultas.model.Perfil;
import ob.unibanca.sicf.generadorconsultas.service.perfil.IPerfilService;




@Validated
@RestController
public class PerfilRestController {
	
	private final IPerfilService perfilService;
	
	public PerfilRestController(IPerfilService perfilService) {
		this.perfilService = perfilService;
	}
	
	@GetMapping(value = "/perfiles-reporteador")
	public List<Perfil> buscarTodosPerfiles() {
		return this.perfilService.buscarTodosPerfiles();
	}
	
	@PostMapping(value = "/perfiles-reporteador", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Perfil registrarPerfil(@Validated({IRegistro.class, Default.class}) @RequestBody Perfil perfil) {
		return this.perfilService.registrarPerfil(perfil);
	}
	
	@PutMapping(value = "/perfiles-reporteador/{idPerfil}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Perfil actualizarPerfil(@IdNumerico(maxRange = 99) @PathVariable int idPerfil,
	                             @Validated @RequestBody Perfil perfil) {
		return this.perfilService.actualizarPerfil(idPerfil, perfil);
	}
	
	@DeleteMapping(value = "/perfiles-reporteador/{idPerfil}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarPerfil(@IdNumerico(maxRange = 99) @PathVariable int idPerfil) {
		this.perfilService.eliminarPerfil(idPerfil);
	}
}