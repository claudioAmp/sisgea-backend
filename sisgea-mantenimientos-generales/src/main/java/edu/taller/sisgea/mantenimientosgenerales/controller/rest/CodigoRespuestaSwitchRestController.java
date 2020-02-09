package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.model.CodigoRespuestaSwitch;
import edu.taller.sisgea.mantenimientosgenerales.service.codigorespuestaswitch.ICodigoRespuestaSwitchService;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class CodigoRespuestaSwitchRestController {
	
	private final ICodigoRespuestaSwitchService codigoRespuestaSwitchService;
	
	public CodigoRespuestaSwitchRestController(ICodigoRespuestaSwitchService codigoRespuestaSwitchService) {
		this.codigoRespuestaSwitchService = codigoRespuestaSwitchService;
	}
	
	@PreAuthorize("hasPermission('MANT_CORPSW', '2')")
	@GetMapping("/codigos-respuestas-switches")
	public List<CodigoRespuestaSwitch> buscarTodosCodigoRespuestaSwitches() {
		return this.codigoRespuestaSwitchService.buscarTodosCodigoRespuetaSwitches();
	}
	
	@PreAuthorize("hasPermission('MANT_CORPSW', '1')")
	@PostMapping(value = "/codigos-respuestas-switches", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CodigoRespuestaSwitch registrarCodigoRespuestaSwitch(
			@Validated({IRegistro.class, Default.class}) @RequestBody CodigoRespuestaSwitch codigoRespuestaSwitch) {
		return this.codigoRespuestaSwitchService.registrarCodigoRespuestaSwitch(codigoRespuestaSwitch);
	}
	
	@PreAuthorize("hasPermission('MANT_CORPSW', '3')")
	@PutMapping(value = "/codigos-respuestas-switches/{idCodigoRespuestaSwitch}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CodigoRespuestaSwitch actualizarCodigoRespuestaSwitch(
			@IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[0-9]+") @PathVariable
					String idCodigoRespuestaSwitch,
			@Validated @RequestBody CodigoRespuestaSwitch codigoRespuestaSwitch) {
		return this.codigoRespuestaSwitchService.actualizarCodigoRespuestaSwitch(idCodigoRespuestaSwitch,
		                                                                         codigoRespuestaSwitch);
	}
	
	@PreAuthorize("hasPermission('MANT_CORPSW', '4')")
	@DeleteMapping("/codigos-respuestas-switches/{idCodigoRespuestaSwitch}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCodigoRespuestaSwitch(
			@IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[0-9]+") @PathVariable
					String idCodigoRespuestaSwitch) {
		this.codigoRespuestaSwitchService.eliminarCodigoRespuestaSwitch(idCodigoRespuestaSwitch);
	}
}
