package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

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

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionFondo;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucionfondo.IDistribucionFondoService;

@Validated
@RestController
public class DistribucionFondoRestController {
	
	private final IDistribucionFondoService distribucionFondoService;
	
	public DistribucionFondoRestController(IDistribucionFondoService distribucionFondoService) {
		this.distribucionFondoService = distribucionFondoService;
	}
	
	@GetMapping("/distribucion-fondo")
	public List<DistribucionFondo> buscarTodosDistFondo(){
		return this.distribucionFondoService.buscarTodosDistFondo();
	}
	
	@PostMapping(value = "/distribucion-fondo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public DistribucionFondo registrarDistribucionFondo(
			@Validated({IRegistro.class, Default.class}) @RequestBody DistribucionFondo distribucionFondo) {
		return this.distribucionFondoService.registrarDistribucionComision(distribucionFondo);
	}
	
	@PutMapping(value = "/distribucion-fondo/{idDistribucionFondo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DistribucionFondo actualizarDistribucionFondo(@IdNumerico(maxRange = 9999) @PathVariable int idDistribucionFondo,
												 @Validated @RequestBody DistribucionFondo distribucionFondo) {
		return this.distribucionFondoService.actualizarDistribucionFondo(idDistribucionFondo, distribucionFondo);
	}
	
	@DeleteMapping("/distribucion-fondo/{idDistribucionFondo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	
	public void eliminarDistribucionFondo(@IdNumerico(maxRange = 9999) @PathVariable int idDistribucionFondo) {
		this.distribucionFondoService.eliminarDistribucionFondo(idDistribucionFondo);
	}
	
}
