package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.InstitucionTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.instituciontransaccion.IInstitucionTransaccionService;

@Validated
@RestController
public class InstitucionTransaccionRestController {

	private final IInstitucionTransaccionService institucionTransaccionService;
	
	public InstitucionTransaccionRestController(IInstitucionTransaccionService institucionTransaccionService) {
		this.institucionTransaccionService = institucionTransaccionService;
	}
	
	@GetMapping("/instituciones-transacciones")
	public List<InstitucionTransaccion> buscarTodosInstitucionesTransacciones(){
		return this.institucionTransaccionService.buscarTodosInstitucionesTransacciones();
	}
		
	@PostMapping(value = "/instituciones-transacciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public InstitucionTransaccion registrarInstitucionTransaccion(
			@Validated({IRegistro.class, Default.class}) @RequestBody InstitucionTransaccion institucionesTransaccion) {
		return this.institucionTransaccionService.registrarInstitucionTransaccion(institucionesTransaccion);
	}
	
	@DeleteMapping(value = "/instituciones/{idInstitucion}/clases-transacciones/{idClaseTransaccion}/codigos-transacciones/{idCodigoTransaccion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarInstitucionTransaccion(
			@IdNumerico(maxRange = 99999) @PathVariable int idInstituciones,
			@IdNumerico(maxRange = 99999) @PathVariable int idClaseTransaccion,
			@IdNumerico(maxRange = 9999) @PathVariable int idCodigoTransaccion) {
		this.institucionTransaccionService.eliminarInstitucionTransaccion(idInstituciones, idClaseTransaccion, idCodigoTransaccion);
	}
}
