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
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionComision;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucioncomision.IDistribucionComisionService;

@Validated
@RestController
public class DistribucionComisionRestController {
	
	private final IDistribucionComisionService distribucionComisionService;
	
	public DistribucionComisionRestController(IDistribucionComisionService distribucionComisionService) {
		this.distribucionComisionService = distribucionComisionService;
	}
	
	@GetMapping("/distribucion-comision")
	public List<DistribucionComision> buscarTodosDistComision(){
		return this.distribucionComisionService.buscarTodosDistComision();
	}
	
	@PostMapping(value = "/distribucion-comision", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public DistribucionComision registrarDistribucionComision(
			@Validated({IRegistro.class, Default.class}) @RequestBody DistribucionComision distribucionComision) {
		return this.distribucionComisionService.registrarDistribucionComision(distribucionComision);
	}
	
	@PutMapping(value = "/distribucion-comision/{idDistribucionComision}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DistribucionComision actualizarDistribucionComision(@IdNumerico(maxRange = 9999) @PathVariable int idDistribucionComision,
													@Validated @RequestBody DistribucionComision distribucionComision) {
		return this.distribucionComisionService.actualizarDistribucionComision(idDistribucionComision, distribucionComision);
	}
	
	@DeleteMapping("/distribucion-comision/{idDistribucionComision}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarDistribucionComision(@IdNumerico(maxRange = 9999) @PathVariable int idDistribucionComision) {
		this.distribucionComisionService.eliminarDistribucionComision(idDistribucionComision);
	}
		
}
	
