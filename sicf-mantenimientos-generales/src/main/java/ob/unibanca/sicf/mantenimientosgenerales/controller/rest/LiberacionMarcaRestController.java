package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.LiberacionMarca;
import ob.unibanca.sicf.mantenimientosgenerales.service.liberacionmarca.ILiberacionMarcaService;
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
public class LiberacionMarcaRestController {
	
	private final ILiberacionMarcaService liberacionMarcaService;
	
	public LiberacionMarcaRestController(ILiberacionMarcaService liberacionMarcaService) {
		this.liberacionMarcaService = liberacionMarcaService;
	}
	
	@PreAuthorize("hasPermission('MANT_LIBMAR', '2')")
	@GetMapping(value = "/liberaciones-marcas")
	public List<LiberacionMarca> buscarTodosLiberacionMarcas() {
		return this.liberacionMarcaService.buscarTodosLiberacionMarcas();
	}
	
	@PreAuthorize("hasPermission('MANT_LIBMAR', '2')")
	@GetMapping(value = "/membresias/{idMembresia}/liberaciones-marcas")
	public List<LiberacionMarca> buscarLiberacionMarcasPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.liberacionMarcaService.buscarLiberacionMarcasPorMembresia(idMembresia);
	}
	
	@PreAuthorize("hasPermission('MANT_LIBMAR', '1')")
	@PostMapping(value = "/membresias/{idMembresia}/productos/{idProducto}/procesos/{idProceso}/liberaciones-marcas",
	             consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public LiberacionMarca registrarLiberacionMarca(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdNumerico(maxRange = 99) @PathVariable Integer idProducto,
			@IdCadena(minLength = 2, maxLength = 2) @PathVariable String idProceso,
			@Validated({IRegistro.class, Default.class}) @RequestBody LiberacionMarca liberacionMarca) {
		return this.liberacionMarcaService.registrarLiberacionMarca(idMembresia, idProducto, idProceso, liberacionMarca);
	}
	
	@PreAuthorize("hasPermission('MANT_LIBMAR', '3')")
	@PutMapping(value = "/membresias/{idMembresia}/productos/{idProducto}/procesos/{idProceso}/liberaciones-marcas",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public LiberacionMarca actualizarLiberacionMarca(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdNumerico(maxRange = 99) @PathVariable Integer idProducto,
			@IdCadena(minLength = 2, maxLength = 2) @PathVariable String idProceso,
			@Validated @RequestBody LiberacionMarca liberacionMarca) {
		return this.liberacionMarcaService.actualizarLiberacionMarca(idMembresia, idProducto, idProceso, liberacionMarca);
	}
	
	@PreAuthorize("hasPermission('MANT_LIBMAR', '4')")
	@DeleteMapping(value = "/membresias/{idMembresia}/productos/{idProducto}/procesos/{idProceso}/liberaciones-marcas")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarLiberacionMarca(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdNumerico(maxRange = 99) @PathVariable Integer idProducto,
			@IdCadena(minLength = 2, maxLength = 2) @PathVariable String idProceso) {
		this.liberacionMarcaService.eliminarLiberacionMarca(idMembresia, idProducto, idProceso);
	}
}
