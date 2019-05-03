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
import ob.unibanca.sicf.generadorconsultas.model.Campo;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampo;
import ob.unibanca.sicf.generadorconsultas.service.campo.ICampoService;




@Validated
@RestController
public class CampoRestController {
	
	private final ICampoService campoService;
	
	public CampoRestController(ICampoService CampoService) {
		this.campoService = CampoService;
	}
	
	@GetMapping(value = "/campos")
	public List<Campo> buscarTodosPermisosUsuario() {
		return this.campoService.buscarTodosCampos();
	}
	@GetMapping(value = "/campos/buscar")
	public List<Campo> buscarTodosPermisosUsuario(CriterioBusquedaCampo criterio) {
		return this.campoService.buscarPorCriteriosCampo(criterio);
	}
	@PostMapping(value = "/campos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Campo registrarCampo(@Validated({IRegistro.class, Default.class}) @RequestBody Campo Campo) {
		return this.campoService.registrarCampo(Campo);
	}
	
	@PutMapping(value = "/campos/{idCampo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Campo actualizarCampo(@IdNumerico(maxRange = 99) @PathVariable int idCampo,
	                             @Validated @RequestBody Campo Campo) {
		return this.campoService.actualizarCampo(idCampo, Campo);
	}
	
	@DeleteMapping(value = "/campos/{idCampo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampo(@IdNumerico(maxRange = 99) @PathVariable int idCampo) {
		this.campoService.eliminarCampo(idCampo);
	}
}