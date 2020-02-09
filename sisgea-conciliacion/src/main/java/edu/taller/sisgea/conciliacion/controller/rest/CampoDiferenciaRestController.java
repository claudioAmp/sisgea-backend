package edu.taller.sisgea.conciliacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.conciliacion.model.CampoDiferencia;
import edu.taller.sisgea.conciliacion.service.campodiferencia.ICampoDiferenciaService;
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

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class CampoDiferenciaRestController {
	
	private final ICampoDiferenciaService campoDiferenciaService;
	
	public CampoDiferenciaRestController(ICampoDiferenciaService campoDiferenciaService) {
		this.campoDiferenciaService = campoDiferenciaService;
	}
	
	@GetMapping(value = "/campos-diferencias")
	public List<CampoDiferencia> buscarTodosCampoDiferencias() {
		return this.campoDiferenciaService.buscarTodosCampoDiferencias();
	}
	
	@GetMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-diferencias")
	public List<CampoDiferencia> buscarCampoDiferenciaPorConciliacionTablas(@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		return this.campoDiferenciaService.buscarCampoDiferenciaPorConciliacionTablas(idConcTabla);
	}
	
	@PostMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-diferencias", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CampoDiferencia registrarCampoDiferencia(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated({IRegistro.class, Default.class}) @RequestBody CampoDiferencia campoDiferencia) {
		return this.campoDiferenciaService.registrarCampoDiferencia(idConcTabla, campoDiferencia);
	}
	
	@PutMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-diferencias/{idCampoDiferencia}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CampoDiferencia actualizarCampoDiferencia(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCampoDiferencia,
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated @RequestBody CampoDiferencia campoDiferencia) {
		return this.campoDiferenciaService.actualizarCampoDiferencia(idCampoDiferencia, idConcTabla, campoDiferencia);
	}
	
	@DeleteMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-diferencias/{idCampoDiferencia}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampoDiferencia(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCampoDiferencia,
	       	@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		this.campoDiferenciaService.eliminarCampoDiferencia(idCampoDiferencia, idConcTabla);
	}
}
