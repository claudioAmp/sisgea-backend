package ob.unibanca.sicf.tarifarios.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.EscenarioTarifa;
import ob.unibanca.sicf.tarifarios.service.escenariotarifa.IEscenarioTarifaService;
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
public class EscenarioTarifaRestController {
	
	private final IEscenarioTarifaService escenarioTarifaService;
	
	public EscenarioTarifaRestController(IEscenarioTarifaService escenarioTarifaService) {
		this.escenarioTarifaService = escenarioTarifaService;
	}
	
	@PreAuthorize("hasPermission('MANT_ESCCONT','2')")
	@GetMapping("/escenarios-tarifas")
	public List<EscenarioTarifa> buscarTodosEscenariosTarifas() {
		return this.escenarioTarifaService.buscarTodosEscenariosTarifas();
	}
	
	@PreAuthorize("hasPermission('MANT_ESCCONT','1')")
	@PostMapping(value = "/escenarios-tarifas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public EscenarioTarifa registrarEscenarioTarifa(
			@Validated({IRegistro.class, Default.class}) @RequestBody EscenarioTarifa escenarioTarifa) {
		return this.escenarioTarifaService.registrarEscenarioTarifa(escenarioTarifa);
	}
	
	@PreAuthorize("hasPermission('MANT_ESCCONT','3')")
	@PutMapping(value = "/escenarios-tarifas/{idEscenarioTarifa}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public EscenarioTarifa actualizarEscenarioTarifa(@IdNumerico(maxRange = 9999) @PathVariable int idEscenarioTarifa,
	                                       @Validated @RequestBody EscenarioTarifa escenarioTarifa) {
		return this.escenarioTarifaService.actualizarEscenarioTarifa(idEscenarioTarifa, escenarioTarifa);
	}
	
	@PreAuthorize("hasPermission('MANT_ESCCONT','4')")
	@DeleteMapping("/escenarios-tarifas/{idEscenarioTarifa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarEscenarioTarifa(@IdNumerico(maxRange = 9999) @PathVariable int idEscenarioTarifa) {
		this.escenarioTarifaService.eliminarEscenarioTarifa(idEscenarioTarifa);
	}

}
