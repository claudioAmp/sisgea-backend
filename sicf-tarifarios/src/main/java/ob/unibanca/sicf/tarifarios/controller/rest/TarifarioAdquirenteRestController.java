package ob.unibanca.sicf.tarifarios.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.TarifarioAdquirente;
import ob.unibanca.sicf.tarifarios.service.tarifarioadquirente.ITarifarioAdquirenteService;
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
public class TarifarioAdquirenteRestController {
	
	private final ITarifarioAdquirenteService tarifarioAdquirenteService;
	
	public TarifarioAdquirenteRestController(ITarifarioAdquirenteService tarifarioAdquirenteService) {
		this.tarifarioAdquirenteService = tarifarioAdquirenteService;
	}
	
	@PreAuthorize("hasPermission('MANT_TARADQ','2')")
	@GetMapping("/tarifarios-adquirentes")
	public List<TarifarioAdquirente> buscarTodosTarifariosAdquirentes() {
		return this.tarifarioAdquirenteService.buscarTodosTarifariosAdquirentes();
	}
	
	@PreAuthorize("hasPermission('MANT_TARADQ','1')")
	@PostMapping(value = "/tarifarios-adquirentes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TarifarioAdquirente registrarTarifarioAdquirente(
			@Validated({IRegistro.class, Default.class}) @RequestBody TarifarioAdquirente tarifarioAdquirente) {
		return this.tarifarioAdquirenteService.registrarTarifarioAdquirente(tarifarioAdquirente);
	}
	
	@PreAuthorize("hasPermission('MANT_TARADQ','3')")
	@PutMapping(value = "/tarifarios-adquirentes/{idTarifarioAdquirente}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TarifarioAdquirente actualizarTarifarioAdquirente(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioAdquirente,
	                                       @Validated @RequestBody TarifarioAdquirente tarifarioAdquirente) {
		return this.tarifarioAdquirenteService.actualizarTarifarioAdquirente(idTarifarioAdquirente, tarifarioAdquirente);
	}
	
	@PreAuthorize("hasPermission('MANT_TARADQ','4')")
	@DeleteMapping("/tarifarios-adquirentes/{idTarifarioAdquirente}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTarifarioAdquirente(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioAdquirente) {
		this.tarifarioAdquirenteService.eliminarTarifarioAdquirente(idTarifarioAdquirente);
	}
	
}
