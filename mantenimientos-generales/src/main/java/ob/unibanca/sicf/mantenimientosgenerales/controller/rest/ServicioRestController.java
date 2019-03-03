package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.Servicio;
import ob.unibanca.sicf.mantenimientosgenerales.service.servicio.IServicioService;
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
public class ServicioRestController {
	
	private final IServicioService servicioService;
	
	public ServicioRestController(IServicioService servicioService) {
		this.servicioService = servicioService;
	}
	
	@GetMapping("/servicios")
	public List<Servicio> buscarTodosServicios() {
		return this.servicioService.buscarTodosServicios();
	}
	
	@PostMapping(value = "/servicios", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Servicio registrarServicio(@Validated({IRegistro.class, Default.class}) @RequestBody Servicio servicio) {
		return this.servicioService.registrarServicio(servicio);
	}
	
	@PutMapping(value = "/servicios/{idMembresia}/{idServicio}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Servicio actualizarServicio(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idServicio,
			@Validated @RequestBody Servicio servicio) {
		return this.servicioService.actualizarServicio(idMembresia, idServicio, servicio);
	}
	
	@DeleteMapping("/servicios/{idMembresia}/{idServicio}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarServicio(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idServicio) {
		this.servicioService.eliminarServicio(idMembresia, idServicio);
	}
}
