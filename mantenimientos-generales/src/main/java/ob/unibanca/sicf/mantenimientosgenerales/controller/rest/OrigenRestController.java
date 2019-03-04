package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.Origen;
import ob.unibanca.sicf.mantenimientosgenerales.service.origen.IOrigenService;
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
public class OrigenRestController {
	
	private final IOrigenService origenService;
	
	public OrigenRestController(IOrigenService origenService) {
		this.origenService = origenService;
	}
	
	@GetMapping("/origenes")
	public List<Origen> buscarTodosOrigens() {
		return this.origenService.buscarTodosOrigenes();
	}
	
	@PostMapping(value = "/origenes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Origen registrarOrigen(
			@Validated({IRegistro.class, Default.class}) @RequestBody Origen origen) {
		return this.origenService.registrarOrigen(origen);
	}
	
	@PutMapping(value = "/origenes/{idOrigen}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Origen actualizarOrigen(@IdNumerico(maxRange = 999) @PathVariable int idOrigen,
	                                       @Validated @RequestBody Origen origen) {
		return this.origenService.actualizarOrigen(idOrigen, origen);
	}
	
	@DeleteMapping("/origenes/{idOrigen}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarOrigen(@IdNumerico(maxRange = 999) @PathVariable int idOrigen) {
		this.origenService.eliminarOrigen(idOrigen);
	}
}
