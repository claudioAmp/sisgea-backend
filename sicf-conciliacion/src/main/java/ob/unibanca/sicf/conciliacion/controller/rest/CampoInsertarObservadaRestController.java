package ob.unibanca.sicf.conciliacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.conciliacion.model.CampoInsertarObservada;
import ob.unibanca.sicf.conciliacion.service.campoinsertarobservada.ICampoInsertarObservadaService;
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
public class CampoInsertarObservadaRestController {
	
	private final ICampoInsertarObservadaService campoInsertarObservadaService;
	
	public CampoInsertarObservadaRestController(ICampoInsertarObservadaService campoInsertarObservadaService) {
		this.campoInsertarObservadaService = campoInsertarObservadaService;
	}
	
	@GetMapping(value = "/campos-insertar-observadas")
	public List<CampoInsertarObservada> buscarTodosCampoInsertarObservadas() {
		return this.campoInsertarObservadaService.buscarTodosCampoInsertarObservadas();
	}
	
	@GetMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-insertar-observadas")
	public List<CampoInsertarObservada> buscarCampoInsertarObservadaPorConciliacionTablas(@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		return this.campoInsertarObservadaService.buscarCampoInsertarObservadaPorConciliacionTablas(idConcTabla);
	}
	
	@PostMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-insertar-observadas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CampoInsertarObservada registrarCampoInsertarObservada(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated({IRegistro.class, Default.class}) @RequestBody CampoInsertarObservada campoInsertarObservada) {
		return this.campoInsertarObservadaService.registrarCampoInsertarObservada(idConcTabla, campoInsertarObservada);
	}
	
	@PutMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-insertar-observadas/{idCmpInsObservada}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CampoInsertarObservada actualizarCampoInsertarObservada(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCmpInsObservada,
			@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla,
			@Validated @RequestBody CampoInsertarObservada campoInsertarObservada) {
		return this.campoInsertarObservadaService.actualizarCampoInsertarObservada(idCmpInsObservada, idConcTabla, campoInsertarObservada);
	}
	
	@DeleteMapping(value = "/conciliaciones-tablas/{idConcTabla}/campos-insertar-observadas/{idCmpInsObservada}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampoInsertarObservada(
			@IdNumerico(maxRange = 9999) @PathVariable Integer idCmpInsObservada,
	       	@IdNumerico(maxRange = 9999) @PathVariable Integer idConcTabla) {
		this.campoInsertarObservadaService.eliminarCampoInsertarObservada(idCmpInsObservada, idConcTabla);
	}
}
