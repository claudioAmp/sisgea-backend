package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedAsociada;
import ob.unibanca.sicf.mantenimientosgenerales.service.atmredasociada.IATMRedAsociadaService;
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
public class ATMRedAsociadaRestController {
	
	private final IATMRedAsociadaService atmRedAsociadaService;
	
	public ATMRedAsociadaRestController(IATMRedAsociadaService atmRedAsociadaService) {
		this.atmRedAsociadaService = atmRedAsociadaService;
	}
	
	@PreAuthorize("hasPermission('MANT_ATREAS', '2')")
	@GetMapping("/atms-redes-asociadas")
	public List<ATMRedAsociada> buscarTodosATMsRedAsociada() {
		return this.atmRedAsociadaService.buscarTodosATMsRedAsociada();
	}
	
	@PreAuthorize("hasPermission('MANT_ATREAS', '2')")
	@GetMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ATMRedAsociada> buscarATMsRedAsociadaPorInstitucion(
			@IdNumerico(maxRange = 9999) @PathVariable int idInstitucion) {
		return this.atmRedAsociadaService.buscarATMsRedAsociadaPorInstitucion(idInstitucion);
	}
	
	@PreAuthorize("hasPermission('MANT_ATREAS', '1')")
	@PostMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas",
	             consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ATMRedAsociada registrarATMRedAsociada(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion,
	                                              @Validated({IRegistro.class, Default.class}) @RequestBody
			                                              ATMRedAsociada atmRedAsociada) {
		return this.atmRedAsociadaService.registrarATMRedAsociada(idInstitucion, atmRedAsociada);
	}
	
	@PreAuthorize("hasPermission('MANT_ATREAS', '3')")
	@PutMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas/{idATM}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ATMRedAsociada actualizarATMRedAsociada(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion,
	                                               @IdNumerico(maxRange = 99999) @PathVariable int idATM,
	                                               @Validated @RequestBody ATMRedAsociada atmRedAsociada) {
		return this.atmRedAsociadaService.actualizarATMRedAsociada(idATM, idInstitucion, atmRedAsociada);
	}
	
	@PreAuthorize("hasPermission('MANT_ATREAS', '4')")
	@DeleteMapping(value = "/instituciones/{idInstitucion}/atms-redes-asociadas/{idATM}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarATMRedAsociada(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion,
	                                   @IdNumerico(maxRange = 99999) @PathVariable int idATM) {
		this.atmRedAsociadaService.eliminarATMRedAsociada(idATM, idInstitucion);
	}
}
