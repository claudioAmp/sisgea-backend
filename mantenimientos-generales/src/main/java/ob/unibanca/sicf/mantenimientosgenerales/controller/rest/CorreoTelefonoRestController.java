package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.CorreoTelefono;
import ob.unibanca.sicf.mantenimientosgenerales.service.correotelefono.ICorreoTelefonoService;
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
public class CorreoTelefonoRestController {
	
	private final ICorreoTelefonoService correoTelefonoService;
	
	public CorreoTelefonoRestController(ICorreoTelefonoService correoTelefonoService) {
		this.correoTelefonoService = correoTelefonoService;
	}
	
	@GetMapping("/correoTelefono")
	public List<CorreoTelefono> buscarTodosCorreoTelefono() {
		return this.correoTelefonoService.buscarTodosCorreoTelefono();
	}
	
	@GetMapping("/membresias/{idMembresia}/correoTelefono")
	public List<CorreoTelefono> buscarCorreoTelefonoPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.correoTelefonoService.buscarCorreoTelefonoPorMembresia(idMembresia);
	}
	
	@PostMapping(value = "/membresias/{idMembresia}/correoTelefono", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CorreoTelefono registrarCorreoTelefono(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@Validated({IRegistro.class, Default.class}) @RequestBody CorreoTelefono correoTelefono) {
		return this.correoTelefonoService.registrarCorreoTelefono(idMembresia, correoTelefono);
	}
	
	@PutMapping(value = "/membresias/{idMembresia}/correoTelefono/{idCorreoTelefono}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CorreoTelefono actualizarCorreoTelefono(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "[a-zA-Z]") @PathVariable String idCorreoTelefono,
			@Validated @RequestBody CorreoTelefono correoTelefono) {
		return this.correoTelefonoService.actualizarCorreoTelefono(idMembresia, idCorreoTelefono, correoTelefono);
	}
	
	@DeleteMapping("/membresias/{idMembresia}/correoTelefono/{idCorreoTelefono}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCorreoTelefono(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "[a-zA-Z]") @PathVariable String idCorreoTelefono) {
		this.correoTelefonoService.eliminarCorreoTelefono(idMembresia, idCorreoTelefono);
	}
}