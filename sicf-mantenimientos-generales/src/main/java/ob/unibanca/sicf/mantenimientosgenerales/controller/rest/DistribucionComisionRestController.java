package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

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
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionComision;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucioncomision.IDistribucionComisionService;

@Validated
@RestController
public class DistribucionComisionRestController {
	
	private final IDistribucionComisionService distribucionComisionService;
	
	public DistribucionComisionRestController(IDistribucionComisionService distribucionComisionService) {
		this.distribucionComisionService = distribucionComisionService;
	}
	@PreAuthorize("hasPermission('MANT_REGCOMPCOM', '2')")
	@GetMapping("/distribuciones-comisiones")
	public List<DistribucionComision> buscarTodosDistComision(){
		return this.distribucionComisionService.buscarTodosDistComision();
	}
	@PreAuthorize("hasPermission('MANT_REGCOMPCOM', '1')")
	@PostMapping(value = "/distribuciones-comisiones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public DistribucionComision registrarDistribucionComision(
			@Validated({IRegistro.class, Default.class}) @RequestBody DistribucionComision distribucionComision) {
		return this.distribucionComisionService.registrarDistribucionComision(distribucionComision);
	}
	@PreAuthorize("hasPermission('MANT_REGCOMPCOM', '3')")
	@PutMapping(value = "/distribuciones-comisiones/{idDistribucionComision}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DistribucionComision actualizarDistribucionComision(@IdNumerico(maxRange = 9999) @PathVariable int idDistribucionComision,
													@Validated @RequestBody DistribucionComision distribucionComision) {
		return this.distribucionComisionService.actualizarDistribucionComision(idDistribucionComision, distribucionComision);
	}
	@PreAuthorize("hasPermission('MANT_REGCOMPCOM', '4')")
	@DeleteMapping("/distribuciones-comisiones/{idDistribucionComision}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarDistribucionComision(@IdNumerico(maxRange = 9999) @PathVariable int idDistribucionComision) {
		this.distribucionComisionService.eliminarDistribucionComision(idDistribucionComision);
	}
		
}
	
