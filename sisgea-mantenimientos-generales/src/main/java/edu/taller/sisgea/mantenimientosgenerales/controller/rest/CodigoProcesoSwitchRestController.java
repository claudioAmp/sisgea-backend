package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.service.codigoprocesoswitch.ICodigoProcesoSwitchService;
import ob.commons.spring.validation.validation.group.IRegistro;
import edu.taller.sisgea.mantenimientosgenerales.model.CodigoProcesoSwitch;
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
public class CodigoProcesoSwitchRestController {
	
	private final ICodigoProcesoSwitchService codigoProcesoSwitchService;
	
	public CodigoProcesoSwitchRestController(ICodigoProcesoSwitchService codigoProcesoSwitchService) {
		this.codigoProcesoSwitchService = codigoProcesoSwitchService;
	}
	
	@PreAuthorize("hasPermission('MANT_COPRSW', '2')")
	@GetMapping(value = "/codigos-procesos-switches")
	public List<CodigoProcesoSwitch> buscarTodosCodigoProcesoSwitches() {
		return this.codigoProcesoSwitchService.buscarTodosCodigoProcesoSwitches();
	}
	
	@PreAuthorize("hasPermission('MANT_COPRSW', '1')")
	@PostMapping(value = "/codigos-procesos-switches", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CodigoProcesoSwitch registrarCodigoProcesoSwitch(
			@Validated({IRegistro.class, Default.class}) @RequestBody CodigoProcesoSwitch codigoProcesoSwitch) {
		System.out.println(codigoProcesoSwitch);
		return this.codigoProcesoSwitchService.registrarCodigoProcesoSwitch(codigoProcesoSwitch);
	}
	
	@PreAuthorize("hasPermission('MANT_COPRSW', '3')")
	@PutMapping(value = "/codigos-procesos-switches/{idCodigoProcesoSwitch}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CodigoProcesoSwitch actualizarCodigoProcesoSwitch(@PathVariable String idCodigoProcesoSwitch, @RequestBody CodigoProcesoSwitch codigoProcesoSwitch) {
		System.out.println(idCodigoProcesoSwitch);
		return this.codigoProcesoSwitchService.actualizarCodigoProcesoSwitch(idCodigoProcesoSwitch,codigoProcesoSwitch);
	}
	
	@PreAuthorize("hasPermission('MANT_COPRSW', '4')")
	@DeleteMapping("/codigos-procesos-switches/{idCodigoProcesoSwitch}")
	public void eliminarCodigoProcesoSwitch(@PathVariable String idCodigoProcesoSwitch) {
		System.out.println(idCodigoProcesoSwitch);
		this.codigoProcesoSwitchService.eliminarCodigoProcesoSwitch(idCodigoProcesoSwitch);
	}
}
