package ob.unibanca.sicf.facturacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.facturacion.model.CodigoFacturacion;
import ob.unibanca.sicf.facturacion.service.codigofacturacion.ICodigoFacturacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class CodigoFacturacionRestController {

	private final ICodigoFacturacionService codigoFacturacionService;
	
	public CodigoFacturacionRestController(ICodigoFacturacionService codigoFacturacionService) {
		this.codigoFacturacionService = codigoFacturacionService;
	}

	@PreAuthorize("hasPermission('MANT_CODFAC','2')")
	@GetMapping("/codigos-facturaciones")
	public List<CodigoFacturacion> buscarTodosCodigosFacturaciones() {
		return this.codigoFacturacionService.buscarTodosCodigosFacturaciones();
	}

	@PreAuthorize("hasPermission('MANT_CODFAC','1')")
	@PostMapping(value = "/codigos-facturaciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CodigoFacturacion registrarCodigoFacturacion(
			@Validated({IRegistro.class, Default.class}) @RequestBody CodigoFacturacion codigoFacturacion) {
		return this.codigoFacturacionService.registrarCodigoFacturacion(codigoFacturacion);
	}

	@PreAuthorize("hasPermission('MANT_CODFAC','3')")
	@PutMapping(value = "/codigos-facturaciones/{idCodigoFacturacion}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CodigoFacturacion actualizarCodigoFacturacion(
			@IdNumerico(maxRange = 99999) @PathVariable int idCodigoFacturacion,
			@Validated @RequestBody CodigoFacturacion codigoFacturacion) {
		return this.codigoFacturacionService.actualizarCodigoFacturacion(idCodigoFacturacion, codigoFacturacion);
	}

	@PreAuthorize("hasPermission('MANT_CODFAC','4')")
	@DeleteMapping("/codigos-facturaciones/{idCodigoFacturacion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCodigoFacturacion(@IdNumerico(maxRange = 99999) @PathVariable int idCodigoFacturacion) {
		this.codigoFacturacionService.eliminarCodigoFacturacion(idCodigoFacturacion);
	}
}
