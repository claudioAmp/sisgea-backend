package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.codigotransaccion.ICodigoTransaccionService;
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
public class CodigoTransaccionRestController {
	
	private final ICodigoTransaccionService codigoTransaccionService;
	
	public CodigoTransaccionRestController(ICodigoTransaccionService codigoTransaccionService) {
		this.codigoTransaccionService = codigoTransaccionService;
	}
	
	@PreAuthorize("hasPermission('MANT_CODTRA', '2')")
	@GetMapping(value = "/codigos-transacciones")
	public List<CodigoTransaccion> buscarTodosCodigoTransacciones() {
		return this.codigoTransaccionService.buscarTodosCodigoTransacciones();
	}
	
	@PreAuthorize("hasPermission('MANT_CODTRA', '2')")
	@GetMapping(value = "/clases-transacciones/{idClaseTransaccion}/codigos-transacciones")
	public List<CodigoTransaccion> buscarCodigosTransaccionPorClaseTransaccion(
			@IdNumerico(maxRange = 9999) @PathVariable int idClaseTransaccion) {
		return this.codigoTransaccionService.buscarCodigosTransaccionPorClaseTransaccion(idClaseTransaccion);
	}
	
	@PreAuthorize("hasPermission('MANT_CODTRA', '1')")
	@PostMapping(value = "/clases-transacciones/{idClaseTransaccion}/codigos-transacciones",
	             consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CodigoTransaccion registrarCodigoTransaccion(
			@IdNumerico(maxRange = 9999) @PathVariable int idClaseTransaccion,
			@Validated({IRegistro.class, Default.class}) @RequestBody CodigoTransaccion codigoTransaccion) {
		return this.codigoTransaccionService.registrarCodigoTransaccion(idClaseTransaccion, codigoTransaccion);
	}
	
	@PreAuthorize("hasPermission('MANT_CODTRA', '3')")
	@PutMapping(value = "/clases-transacciones/{idClaseTransaccion}/codigos-transacciones/{idCodigoTransaccion}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CodigoTransaccion actualizarCodigoTransaccion(
			@IdNumerico(maxRange = 9999) @PathVariable int idClaseTransaccion,
			@IdNumerico(maxRange = 9999) @PathVariable int idCodigoTransaccion,
			@Validated @RequestBody CodigoTransaccion codigoTransaccion) {
		return this.codigoTransaccionService.actualizarCodigoTransaccion(idClaseTransaccion, idCodigoTransaccion,
		                                                                 codigoTransaccion);
	}
	
	@PreAuthorize("hasPermission('MANT_CODTRA', '4')")
	@DeleteMapping(value = "/clases-transacciones/{idClaseTransaccion}/codigos-transacciones/{idCodigoTransaccion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCodigoTransaccion(@IdNumerico(maxRange = 9999) @PathVariable int idClaseTransaccion,
	                                      @IdNumerico(maxRange = 9999) @PathVariable int idCodigoTransaccion) {
		this.codigoTransaccionService.eliminarCodigoTransaccion(idClaseTransaccion, idCodigoTransaccion);
	}
}
