package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;
import ob.unibanca.sicf.mantenimientosgenerales.service.codigoprocesoswitch.ICodigoProcesoSwitchService;
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
public class CodigoProcesoSwitchRestController {
	
	private final ICodigoProcesoSwitchService codigoProcesoSwitchService;
	
	public CodigoProcesoSwitchRestController(ICodigoProcesoSwitchService codigoProcesoSwitchService) {
		this.codigoProcesoSwitchService = codigoProcesoSwitchService;
	}
	
	@GetMapping(value = "/codigos-procesos-switches")
	public List<CodigoProcesoSwitch> buscarTodosCodigoProcesoSwitches() {
		return this.codigoProcesoSwitchService.buscarTodosCodigoProcesoSwitches();
	}
	
	@PostMapping(value = "/codigos-procesos-switches", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CodigoProcesoSwitch registrarCodigoProcesoSwitch(
			@Validated({IRegistro.class, Default.class}) @RequestBody CodigoProcesoSwitch codigoProcesoSwitch) {
		System.out.println(codigoProcesoSwitch);
		return this.codigoProcesoSwitchService.registrarCodigoProcesoSwitch(codigoProcesoSwitch);
	}
	
	@PutMapping(value = "/codigos-procesos-switches/{idCodigoProcesoSwitch}",
	            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CodigoProcesoSwitch actualizarCodigoProcesoSwitch(@PathVariable String idCodigoProcesoSwitch, @RequestBody CodigoProcesoSwitch codigoProcesoSwitch) {
		System.out.println(idCodigoProcesoSwitch);
		return this.codigoProcesoSwitchService.actualizarCodigoProcesoSwitch(idCodigoProcesoSwitch,
		                                                                     codigoProcesoSwitch);
	}
	
	@DeleteMapping("/codigos-procesos-switches/{idCodigoProcesoSwitch}")
	public void eliminarCodigoProcesoSwitch(@PathVariable String idCodigoProcesoSwitch) {
		System.out.println(idCodigoProcesoSwitch);
		this.codigoProcesoSwitchService.eliminarCodigoProcesoSwitch(idCodigoProcesoSwitch);
	}
}
