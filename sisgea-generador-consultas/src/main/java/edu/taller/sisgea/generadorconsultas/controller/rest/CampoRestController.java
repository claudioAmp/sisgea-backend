package edu.taller.sisgea.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import edu.taller.sisgea.generadorconsultas.model.Campo;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampo;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaConjuntoCampo;
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
import edu.taller.sisgea.generadorconsultas.service.campo.ICampoService;

@Validated
@RestController
public class CampoRestController {
	
	private final ICampoService campoService;
	
	public CampoRestController(ICampoService CampoService) {
		this.campoService = CampoService;
	}
	
	@GetMapping(value = "/campos")
	public List<Campo> buscarTodosCampos() {
		return this.campoService.buscarTodosCampos();
	}
	
	@GetMapping(value = "/campos/{idCampo}")
	public Campo buscarPorId(@PathVariable int idCampo) {
		return this.campoService.buscarPorId(idCampo);
	}
	
	@GetMapping(value = "/campos/tabla/{idTabla}")
	public List<Campo> buscarIdTabla(@PathVariable int idTabla) {
		return this.campoService.buscarIdTabla(idTabla);
	}
	
	@GetMapping(value = "/campos/buscar")
	public List<Campo> buscarTodosCampos(CriterioBusquedaCampo criterio) {
		return this.campoService.buscarPorCriteriosCampo(criterio);
	}
	
	@GetMapping(value = "/campos/buscar/conjunto")
	public List<Campo> buscarConjuntoCampos(CriterioBusquedaConjuntoCampo criterio) {
		return this.campoService.buscarConjuntoCampos(criterio);
	}
	
	@GetMapping(value = "/campos/permitidos")
	public List<Campo> buscarCamposPorUsuarioActivo() {
		return this.campoService.buscarCamposPorUsuarioActivo();
	}
	
	@PostMapping(value = "/campos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Campo registrarCampo(@Validated({IRegistro.class, Default.class}) @RequestBody Campo Campo) {
		return this.campoService.registrarCampo(Campo);
	}
	
	@PutMapping(value = "/campos/{idCampo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Campo actualizarCampo(@IdNumerico(minRange=0, maxRange = 99999) @PathVariable int idCampo,
	                             @Validated @RequestBody Campo Campo) {
		return this.campoService.actualizarCampo(idCampo, Campo);
	}
	
	@DeleteMapping(value = "/campos/{idCampo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampo(@IdNumerico(maxRange = 99999) @PathVariable int idCampo) {
		this.campoService.eliminarCampo(idCampo);
	}
}