package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.RespuestaMarcaInt;
import ob.unibanca.sicf.mantenimientosgenerales.service.respuestamarcaint.IRespuestaMarcaIntService;
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
public class RespuestaMarcaIntRestController {
	
	private final IRespuestaMarcaIntService respuestaMarcaIntService;
	
	public RespuestaMarcaIntRestController(IRespuestaMarcaIntService respuestaMarcaIntService) {
		this.respuestaMarcaIntService = respuestaMarcaIntService;
	}
	
	@PreAuthorize("hasPermission('MANT_CODRPTAMEMB', '2')")
	@GetMapping("/respuestas-marcas-int")
	public List<RespuestaMarcaInt> buscarTodosRespuestasMarcasInt() {
		return this.respuestaMarcaIntService.buscarTodosRespuestasMarcasInt();
	}
	
	@PreAuthorize("hasPermission('MANT_CODRPTAMEMB', '2')")
	@GetMapping("/membresias/{idMembresia}/respuestas-marcas-int")
	public List<RespuestaMarcaInt> buscarRespuestasMarcasIntPorMembresia(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia) {
		return this.respuestaMarcaIntService.buscarRespuestasMarcasIntPorMembresia(idMembresia);
	}
	
	@PreAuthorize("hasPermission('MANT_CODRPTAMEMB', '1')")
	@PostMapping(value = "/membresias/{idMembresia}/respuestas-marcas-int", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public RespuestaMarcaInt registrarRespuestaMarcaInt(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@Validated({IRegistro.class, Default.class}) @RequestBody RespuestaMarcaInt respuestaMarcaInt) {
		return this.respuestaMarcaIntService.registrarRespuestaMarcaInt(idMembresia, respuestaMarcaInt);
	}
	
	@PreAuthorize("hasPermission('MANT_CODRPTAMEMB', '3')")
	@PutMapping(value = "/membresias/{idMembresia}/respuestas-marcas-int/{idRespuesta}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RespuestaMarcaInt actualizarRespuestaMarcaInt(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[a-zA-Z0-9]+") @PathVariable String idRespuesta,
			@Validated @RequestBody RespuestaMarcaInt respuestaMarcaInt) {
		return this.respuestaMarcaIntService.actualizarRespuestaMarcaInt(idMembresia, idRespuesta, respuestaMarcaInt);
	}
	
	@PreAuthorize("hasPermission('MANT_CODRPTAMEMB', '4')")
	@DeleteMapping("/membresias/{idMembresia}/respuestas-marcas-int/{idRespuesta}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarRespuestaMarcaIntS(
			@IdCadena(minLength = 1, maxLength = 1, regexpPattern = "[a-zA-Z]") @PathVariable String idMembresia,
			@IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[a-zA-Z0-9]+") @PathVariable String idRespuesta) {
		this.respuestaMarcaIntService.eliminarRespuestaMarcaInt(idMembresia, idRespuesta);
	}
}
