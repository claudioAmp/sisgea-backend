package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.CapacidadTerminalPOS;
import ob.unibanca.sicf.mantenimientosgenerales.service.capacidadterminalpos.ICapacidadTerminalPOSService;
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
public class CapacidadTerminalPOSRestController {
	
	private final ICapacidadTerminalPOSService capacidadTerminalPOSService;
	
	public CapacidadTerminalPOSRestController(ICapacidadTerminalPOSService capacidadTerminalPOSService) {
		this.capacidadTerminalPOSService = capacidadTerminalPOSService;
	}
	
	@GetMapping("/capacidadTerminalPOS")
	public List<CapacidadTerminalPOS> buscarTodosCapacidadTerminalPOS() {
		return this.capacidadTerminalPOSService.buscarTodosCapacidadTerminalPOS();
	}
	
	@GetMapping("/membresias/{idMembresia}/capacidadTerminalPOS")
	public List<CapacidadTerminalPOS> buscarCapacidadTerminalPOSPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.capacidadTerminalPOSService.buscarCapacidadTerminalPOSPorMembresia(idMembresia);
	}
	
	@PostMapping(value = "/membresias/{idMembresia}/capacidadTerminalPOS", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CapacidadTerminalPOS registrarCapacidadTerminalPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@Validated({IRegistro.class, Default.class}) @RequestBody CapacidadTerminalPOS capacidadTerminalPOS) {
		return this.capacidadTerminalPOSService.registrarCapacidadTerminalPOS(idMembresia, capacidadTerminalPOS);
	}
	
	@PutMapping(value = "/membresias/{idMembresia}/capacidadTerminalPOS/{idTerminalPOS}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CapacidadTerminalPOS actualizarCapacidadTerminalPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "[a-zA-Z]") @PathVariable String idTerminalPOS,
			@Validated @RequestBody CapacidadTerminalPOS capacidadTerminalPOS) {
		return this.capacidadTerminalPOSService.actualizarCapacidadTerminalPOS(idMembresia, idTerminalPOS, capacidadTerminalPOS);
	}
	
	@DeleteMapping("/membresias/{idMembresia}/capacidadTerminalPOS/{idTerminalPOS}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCapacidadTerminalPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "[a-zA-Z]") @PathVariable String idTerminalPOS) {
		this.capacidadTerminalPOSService.eliminarCapacidadTerminalPOS(idMembresia, idTerminalPOS);
	}
}
