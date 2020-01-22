package ob.unibanca.sicf.facturacion.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

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

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.facturacion.model.Detraccion;
import ob.unibanca.sicf.facturacion.service.detraccion.IDetraccionService;

@Validated
@RestController
public class DetraccionRestController {
	private final IDetraccionService detraccionService;

	public DetraccionRestController(IDetraccionService detraccionService) {
		this.detraccionService = detraccionService;
	}
	
	@PreAuthorize("hasPermission('MANT_DETRAC', '2')")
	@GetMapping("/detraccion")
	public List<Detraccion> buscarTodosDetraccion() {
		return this.detraccionService.buscarTodosDetraccion();
	}
	
	@PreAuthorize("hasPermission('MANT_DETRAC', '1')")
	@PostMapping(value = "/detraccion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Detraccion registrarDetraccion(
			@Validated({ IRegistro.class, Default.class }) @RequestBody Detraccion detraccion) {
		return this.detraccionService.registrarDetraccion(detraccion);
	}
	
	@PreAuthorize("hasPermission('MANT_DETRAC', '3')")
	@PutMapping(value = "/detraccion/{idDetraccion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Detraccion actualizarDetraccion(@IdNumerico(maxRange = 999999) @PathVariable int idDetraccion,
			@Validated @RequestBody Detraccion detraccion) {
		return this.detraccionService.actualizarDetraccion(idDetraccion, detraccion);
	}
	
	@PreAuthorize("hasPermission('MANT_DETRAC', '4')")
	@DeleteMapping("/detraccion/{idDetraccion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarDetraccion (@IdNumerico(maxRange = 999999) @PathVariable int idDetraccion) {
		this.detraccionService.eliminarDetraccion(idDetraccion);
	}
	
}
