package edu.taller.sisgea.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import edu.taller.sisgea.generadorconsultas.model.CampoPerfil;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaPerfilCampoActualizarMasivo;
import edu.taller.sisgea.generadorconsultas.service.campoperfil.ICampoPerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class CampoPerfilRestController {
	
	private final ICampoPerfilService campoPerfilService;
	
	public CampoPerfilRestController(ICampoPerfilService campoPerfilService) {
		this.campoPerfilService = campoPerfilService;
	}
	
	@GetMapping(value = "/campos-perfil")
	public List<CampoPerfil> buscarTodosCanales() {
		return this.campoPerfilService.buscarTodosCampoPerfil();
	}
	
	@GetMapping(value = "/campos-perfil/buscar")
	public List<CampoPerfil> buscarTodosCanales(CriterioBusquedaCampoPerfil criterio) {
		return this.campoPerfilService.buscarPorCriteriosCampoPerfil(criterio);
	}
	
	@GetMapping(value = "/campos-perfil/campos-asignables")
	public List<CampoPerfil> buscarCamposAsignables(CriterioBusquedaCampoPerfil criterio) {
		return this.campoPerfilService.buscarCamposAsignables(criterio);
	}

	@PostMapping(value = "/campos-perfil", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CampoPerfil registrarCampoPerfil(@Validated({IRegistro.class, Default.class}) @RequestBody CampoPerfil campoPerfil) {
		return this.campoPerfilService.registrarCampoPerfil(campoPerfil);
	}
	
	@PutMapping(value = "/campos-perfil/{idPerfilRepCampo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CampoPerfil actualizarCampoPerfil(@IdNumerico(maxRange = 99) @PathVariable Integer idPerfilRepCampo,
	                             @Validated @RequestBody CampoPerfil CampoPerfil) {
		return this.campoPerfilService.actualizarCampoPerfil(idPerfilRepCampo, CampoPerfil);
	}
	
	@DeleteMapping(value = "/campos-perfil/{idPerfilRepCampo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampoPerfil(@IdNumerico(maxRange = 99) @PathVariable Integer idPerfilRepCampo) {
		this.campoPerfilService.eliminarCampoPerfil(idPerfilRepCampo);
	}
	
	@PutMapping(value = "/campos-perfil/{idPerfil}/{listaModificacion}/{usuario}")
	public void actualizarCamposDePerfil(@IdNumerico(maxRange = 9999) @PathVariable int idPerfil,
			 @PathVariable  String listaModificacion,  @PathVariable String usuario) {
		System.out.println(idPerfil);
		System.out.println(listaModificacion);
		this.campoPerfilService.actualizarCamposDePerfil(idPerfil, listaModificacion, usuario);
	}
	
	@PostMapping(value = "/campos-perfil/registrar-masivo")
	public ResponseEntity<?> registrarCamposDePerfilMasivo(@RequestBody CriterioBusquedaPerfilCampoActualizarMasivo criterio) {
		this.campoPerfilService.actualizarCamposDePerfilMasivo(criterio);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
