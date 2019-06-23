package ob.unibanca.sicf.tarifarios.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.TarifarioSurcharge;
import ob.unibanca.sicf.tarifarios.service.tarifariosurcharge.ITarifarioSurchargeService;
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
public class TarifarioSurchargeRestController {
	
	private final ITarifarioSurchargeService tarifarioSurchargeService;
	
	public TarifarioSurchargeRestController(ITarifarioSurchargeService tarifarioSurchargeService) {
		this.tarifarioSurchargeService = tarifarioSurchargeService;
	}
	
	@PreAuthorize("hasPermission('MANT_TARSUR','2')")
	@GetMapping("/tarifarios-surcharges")
	public List<TarifarioSurcharge> buscarTodosTarifariosSurcharges() {
		return this.tarifarioSurchargeService.buscarTodosTarifariosSurcharges();
	}
	
	@PreAuthorize("hasPermission('MANT_TARSUR','1')")
	@PostMapping(value = "/tarifarios-surcharges", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TarifarioSurcharge registrarTarifarioSurcharge(
			@Validated({IRegistro.class, Default.class}) @RequestBody TarifarioSurcharge tarifarioSurcharge) {
		return this.tarifarioSurchargeService.registrarTarifarioSurcharge(tarifarioSurcharge);
	}
	
	@PreAuthorize("hasPermission('MANT_TARSUR','3')")
	@PutMapping(value = "/tarifarios-surcharges/{idTarifarioSurcharge}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TarifarioSurcharge actualizarTarifarioSurcharge(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioSurcharge,
			@Validated @RequestBody TarifarioSurcharge tarifarioSurcharge) {
		return this.tarifarioSurchargeService.actualizarTarifarioSurcharge(idTarifarioSurcharge, tarifarioSurcharge);
	}
	
	@PreAuthorize("hasPermission('MANT_TARSUR','4')")
	@DeleteMapping("/tarifarios-surcharges/{idTarifarioSurcharge}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTarifarioSurcharge(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioSurcharge) {
		this.tarifarioSurchargeService.eliminarTarifarioSurcharge(idTarifarioSurcharge);
	}
	
}
