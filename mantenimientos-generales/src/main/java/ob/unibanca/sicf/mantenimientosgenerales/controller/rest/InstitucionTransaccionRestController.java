package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.InstitucionTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.instituciontransaccion.IInstitucionTransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class InstitucionTransaccionRestController {
	
	private final IInstitucionTransaccionService institucionTransaccionService;
	
	public InstitucionTransaccionRestController(IInstitucionTransaccionService institucionTransaccionService) {
		this.institucionTransaccionService = institucionTransaccionService;
	}
	
	@PreAuthorize("hasPermission('MANT_INSTRA', '2')")
	@GetMapping("/instituciones-transacciones")
	public List<InstitucionTransaccion> buscarTodosInstitucionesTransacciones() {
		return this.institucionTransaccionService.buscarTodosInstitucionesTransacciones();
	}
	
	@PreAuthorize("hasPermission('MANT_INSTRA', '1')")
	@PostMapping(value = "/instituciones/{idInstitucion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public InstitucionTransaccion registrarInstitucionTransaccion(
			@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion,
			@Validated({IRegistro.class, Default.class}) @RequestBody InstitucionTransaccion institucionesTransaccion) {
		return this.institucionTransaccionService.registrarInstitucionTransaccion(idInstitucion,
		                                                                          institucionesTransaccion);
	}
	
	@PreAuthorize("hasPermission('MANT_INSTRA', '4')")
	@DeleteMapping("/instituciones/{idInstitucion}/clases-transacciones/{idClaseTransaccion}/codigos-transacciones" +
	               "/{idCodigoTransaccion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarInstitucionTransaccion(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion,
	                                           @IdNumerico(maxRange = 99999) @PathVariable int idClaseTransaccion,
	                                           @IdNumerico(maxRange = 9999) @PathVariable int idCodigoTransaccion) {
		this.institucionTransaccionService.eliminarInstitucionTransaccion(idInstitucion, idClaseTransaccion,
		                                                                  idCodigoTransaccion);
	}
}
