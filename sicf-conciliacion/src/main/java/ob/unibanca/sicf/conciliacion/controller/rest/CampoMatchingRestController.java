package ob.unibanca.sicf.conciliacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.conciliacion.model.CampoMatching;
import ob.unibanca.sicf.conciliacion.service.campomatching.ICampoMatchingService;
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
public class CampoMatchingRestController {
	
	private final ICampoMatchingService campoMatchingService;
	
	public CampoMatchingRestController(ICampoMatchingService campoMatchingService) {
		this.campoMatchingService = campoMatchingService;
	}
	
	@GetMapping(value = "/campos-matching")
	public List<CampoMatching> buscarTodosCamposMatching() {
		return this.campoMatchingService.buscarTodosCamposMatching();
	}
	
	@GetMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-matching")
	public List<CampoMatching> buscarCampoMatchingPorConciliacionTablas(@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		return this.campoMatchingService.buscarCampoMatchingPorConciliacionTablas(idConcTabla);
	}
	
	@PostMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-matching", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CampoMatching registrarCampoMatching(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated({IRegistro.class, Default.class}) @RequestBody CampoMatching conciliacionTablas) {
		return this.campoMatchingService.registrarCampoMatching(idConcTabla, conciliacionTablas);
	}
	
	@PutMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-matching/{idCampoMatching}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CampoMatching actualizarCampoMatching(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCampoMatching,
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated @RequestBody CampoMatching conciliacionTablas) {
		return this.campoMatchingService.actualizarCampoMatching(idCampoMatching, idConcTabla, conciliacionTablas);
	}
	
	@DeleteMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-matching/{idCampoMatching}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampoMatching(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCampoMatching,
	       	@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		this.campoMatchingService.eliminarCampoMatching(idCampoMatching, idConcTabla);
	}
}
