package ob.unibanca.sicf.facturacion.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.facturacion.model.CodigoFacturacion;
import ob.unibanca.sicf.facturacion.service.codigofacturacion.ICodigoFacturacionService;
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
public class CodigoFacturacionRestController {
	
	private final ICodigoFacturacionService codigoFacturacionService;
	
	public CodigoFacturacionRestController(ICodigoFacturacionService codigoFacturacionService) {
		this.codigoFacturacionService = codigoFacturacionService;
	}
	
	@GetMapping("/codigos-facturaciones")
	public List<CodigoFacturacion> buscarTodosCodigosFacturaciones() {
		return this.codigoFacturacionService.buscarTodosCodigosFacturaciones();
	}
	
	@PostMapping(value = "/codigos-facturaciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CodigoFacturacion registrarCodigoFacturacion(@Validated({IRegistro.class, Default.class}) @RequestBody CodigoFacturacion codigoFacturacion) {
		return this.codigoFacturacionService.registrarCodigoFacturacion(codigoFacturacion);
	}
	
	@PutMapping(value = "/codigos-facturaciones/{idCodigoFacturacion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CodigoFacturacion actualizarCodigoFacturacion(
		@IdNumerico(maxRange = 99999, groups = IRegistro.class) @PathVariable int idCodigoFacturacion,
			@Validated @RequestBody CodigoFacturacion codigoFacturacion) {
		return this.codigoFacturacionService.actualizarCodigoFacturacion(idCodigoFacturacion, codigoFacturacion);
	}
	
	@DeleteMapping("/codigos-facturaciones/{idCodigoFacturacion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCodigoFacturacion(
		@IdNumerico(maxRange = 99999, groups = IRegistro.class) @PathVariable int idCodigoFacturacion) {
		this.codigoFacturacionService.eliminarCodigoFacturacion(idCodigoFacturacion);
	}
	
}
