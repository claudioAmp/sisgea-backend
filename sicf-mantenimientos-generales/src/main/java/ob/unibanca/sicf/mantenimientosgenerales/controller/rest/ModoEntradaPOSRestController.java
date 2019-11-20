package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ModoEntradaPOS;
import ob.unibanca.sicf.mantenimientosgenerales.service.modoentradapos.IModoEntradaPOSService;
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
public class ModoEntradaPOSRestController {
	
	private final IModoEntradaPOSService modoEntradaPOSService;
	
	public ModoEntradaPOSRestController(IModoEntradaPOSService modoEntradaPOSService) {
		this.modoEntradaPOSService = modoEntradaPOSService;
	}
	
	@PreAuthorize("hasPermission('MANT_MODENTPOS', '2')")
	@GetMapping("/modos-entradas-pos")
	public List<ModoEntradaPOS> buscarTodosModosEntradasPOS() {
		return this.modoEntradaPOSService.buscarTodosModosEntradasPOS();
	}
	
	@PreAuthorize("hasPermission('MANT_MODENTPOS', '2')")
	@GetMapping("/membresias/{idMembresia}/modos-entradas-pos")
	public List<ModoEntradaPOS> buscarModosEntradasPOSPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.modoEntradaPOSService.buscarModosEntradasPOSPorMembresia(idMembresia);
	}
	
	@PreAuthorize("hasPermission('MANT_MODENTPOS', '1')")
	@PostMapping(value = "/membresias/{idMembresia}/modos-entradas-pos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ModoEntradaPOS registrarModoEntradaPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@Validated({IRegistro.class, Default.class}) @RequestBody ModoEntradaPOS modoEntradaPOS) {
		return this.modoEntradaPOSService.registrarModoEntradaPOS(idMembresia, modoEntradaPOS);
	}
	
	@PreAuthorize("hasPermission('MANT_MODENTPOS', '3')")
	@PutMapping(value = "/membresias/{idMembresia}/modos-entradas-pos/{idModoEntradaPOS}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModoEntradaPOS actualizarModoEntradaPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 2, regexpPattern = "[0-9]*") @PathVariable String idModoEntradaPOS,
			@Validated @RequestBody ModoEntradaPOS modoEntradaPOS) {
		return this.modoEntradaPOSService.actualizarModoEntradaPOS(idMembresia, idModoEntradaPOS, modoEntradaPOS);
	}
	
	@PreAuthorize("hasPermission('MANT_MODENTPOS', '4')")
	@DeleteMapping("/membresias/{idMembresia}/modos-entradas-pos/{idModoEntradaPOS}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarModoEntradaPOS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 2, regexpPattern = "[0-9]*") @PathVariable String idModoEntradaPOS) {
		this.modoEntradaPOSService.eliminarModoEntradaPOS(idMembresia, idModoEntradaPOS);
	}
}
