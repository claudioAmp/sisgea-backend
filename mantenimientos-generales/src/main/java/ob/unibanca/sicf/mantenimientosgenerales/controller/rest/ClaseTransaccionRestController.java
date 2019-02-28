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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ClaseTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.claseTransaccion.IClaseTransaccionService;

@Validated
@RestController
public class ClaseTransaccionRestController {

	private final IClaseTransaccionService claseTransaccionService;

	public ClaseTransaccionRestController(IClaseTransaccionService claseTransaccionService) {
		this.claseTransaccionService = claseTransaccionService;
	}

	@GetMapping(value = "/claseTransacciones")
	public List<ClaseTransaccion> buscarTodosClaseTransacciones() {
		return this.claseTransaccionService.buscarTodosClaseTransacciones();
	}

	@PostMapping(value = "/claseTransacciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClaseTransaccion registrarClaseTransaccion(
			@Validated({ IRegistro.class, Default.class }) @RequestBody ClaseTransaccion claseTransaccion) {
		return this.claseTransaccionService.registrarClaseTransaccion(claseTransaccion);
	}

	@PutMapping(value = "/claseTransacciones/{idClaseTransaccion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ClaseTransaccion actualizarClaseTransaccion(
			@IdNumerico(maxRange = 99999) @PathVariable int idClaseTransaccion,
			@Validated @RequestBody ClaseTransaccion claseTransaccion) {
		return this.claseTransaccionService.actualizarClaseTransaccion(idClaseTransaccion, claseTransaccion);
	}

	@DeleteMapping(value = "/claseTransacciones/{idClaseTransaccion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarClaseTransaccion(@IdNumerico(maxRange = 99999) @PathVariable int idClaseTransaccion) {
		this.claseTransaccionService.eliminarClaseTransaccion(idClaseTransaccion);
	}

}
