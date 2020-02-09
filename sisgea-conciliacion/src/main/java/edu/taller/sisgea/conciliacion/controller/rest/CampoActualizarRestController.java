package edu.taller.sisgea.conciliacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.conciliacion.model.CampoActualizar;
import edu.taller.sisgea.conciliacion.service.campoactualizar.ICampoActualizarService;
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
public class CampoActualizarRestController {
	
	private final ICampoActualizarService campoActualizarService;
	
	public CampoActualizarRestController(ICampoActualizarService campoActualizarService) {
		this.campoActualizarService = campoActualizarService;
	}
	
	@GetMapping(value = "/campos-actualizar")
	public List<CampoActualizar> buscarTodosCamposActualizar() {
		return this.campoActualizarService.buscarTodosCamposActualizar();
	}
	
	@GetMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-actualizar")
	public List<CampoActualizar> buscarCampoActualizarPorConciliacionTablas(@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		return this.campoActualizarService.buscarCampoActualizarPorConciliacionTablas(idConcTabla);
	}
	
	@PostMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-actualizar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CampoActualizar registrarCampoActualizar(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated({IRegistro.class, Default.class}) @RequestBody CampoActualizar campoActualizar) {
		return this.campoActualizarService.registrarCampoActualizar(idConcTabla, campoActualizar);
	}
	
	@PutMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-actualizar/{idCampoActualizar}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CampoActualizar actualizarCampoActualizar(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCampoActualizar,
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated @RequestBody CampoActualizar campoActualizar) {
		return this.campoActualizarService.actualizarCampoActualizar(idCampoActualizar, idConcTabla, campoActualizar);
	}
	
	@DeleteMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-actualizar/{idCampoActualizar}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampoActualizar(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCampoActualizar,
	       	@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		this.campoActualizarService.eliminarCampoActualizar(idCampoActualizar, idConcTabla);
	}
}
