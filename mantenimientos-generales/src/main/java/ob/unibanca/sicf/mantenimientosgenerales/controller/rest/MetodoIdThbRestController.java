package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;
import javax.validation.groups.Default;
import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.MetodoIdThb;
import ob.unibanca.sicf.mantenimientosgenerales.service.metodoidthb.IMetodoIdThbService;
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


@Validated
@RestController
public class MetodoIdThbRestController {
    private final IMetodoIdThbService metodoIdThbService;
	
	public MetodoIdThbRestController(IMetodoIdThbService metodoIdThbService) {
		this.metodoIdThbService = metodoIdThbService;
	}
	
	@GetMapping("/metodos-id-thb")
	public List<MetodoIdThb> buscarTodosMetodoIdThb() {
		return this.metodoIdThbService.buscarTodosMetodoIdThb();
	}
	
	@GetMapping("/membresias/{idMembresia}/metodos-id-thb")
	public List<MetodoIdThb> buscarMetodoIdThbPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.metodoIdThbService.buscarMetodoIdThbPorMembresia(idMembresia);
	}
	
	@PostMapping(value = "/membresias/{idMembresia}/metodos-id-thb", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public MetodoIdThb registrarMetodoIdThb(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@Validated({IRegistro.class, Default.class}) @RequestBody MetodoIdThb metodoIdThb) {
		return this.metodoIdThbService.registrarMetodoIdThb(idMembresia, metodoIdThb);
	}
	
	@PutMapping(value = "/membresias/{idMembresia}/metodos-id-thb/{idMetodoIdThb}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MetodoIdThb actualizarMetodoIdThb(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[0-9]+") @PathVariable String idMetodoIdThb,
			@Validated @RequestBody MetodoIdThb metodoIdThb) {
		return this.metodoIdThbService.actualizarMetodoIdThb(idMembresia, idMetodoIdThb, metodoIdThb);
	}
	
	@DeleteMapping("/membresias/{idMembresia}/metodos-id-thb/{idMetodoIdThb}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarMetodoIdThb(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[0-9]+") @PathVariable String idMetodoIdThb) {
		this.metodoIdThbService.eliminarMetodoIdThb(idMembresia, idMetodoIdThb);
	}
}
