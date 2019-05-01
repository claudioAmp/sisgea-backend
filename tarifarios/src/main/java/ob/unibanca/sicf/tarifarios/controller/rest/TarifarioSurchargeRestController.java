package ob.unibanca.sicf.tarifarios.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.TarifarioSurcharge;
import ob.unibanca.sicf.tarifarios.service.tarifariosurcharge.ITarifarioSurchargeService;
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
public class TarifarioSurchargeRestController {
	
	private final ITarifarioSurchargeService tarifarioSurchargeService;
	
	public TarifarioSurchargeRestController(ITarifarioSurchargeService tarifarioSurchargeService) {
		this.tarifarioSurchargeService = tarifarioSurchargeService;
	}
	
	@GetMapping("/tarifarios-surcharges")
	public List<TarifarioSurcharge> buscarTodosTarifariosSurcharges() {
		return this.tarifarioSurchargeService.buscarTodosTarifariosSurcharges();
	}
	
	@PostMapping(value = "/tarifarios-surcharges", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TarifarioSurcharge registrarTarifarioSurcharge(
			@Validated({IRegistro.class, Default.class}) @RequestBody TarifarioSurcharge tarifarioSurcharge) {
		return this.tarifarioSurchargeService.registrarTarifarioSurcharge(tarifarioSurcharge);
	}
	
	@PutMapping(value = "/tarifarios-surcharges/{idTarifarioSurcharge}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TarifarioSurcharge actualizarTarifarioSurcharge(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioSurcharge,
	                                       @Validated @RequestBody TarifarioSurcharge tarifarioSurcharge) {
		return this.tarifarioSurchargeService.actualizarTarifarioSurcharge(idTarifarioSurcharge, tarifarioSurcharge);
	}
	
	@DeleteMapping("/tarifarios-surcharges/{idTarifarioSurcharge}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTarifarioSurcharge(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioSurcharge) {
		this.tarifarioSurchargeService.eliminarTarifarioSurcharge(idTarifarioSurcharge);
	}
	
}
