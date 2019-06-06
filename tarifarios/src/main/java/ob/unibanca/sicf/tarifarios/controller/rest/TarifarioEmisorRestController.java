package ob.unibanca.sicf.tarifarios.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.TarifarioEmisor;
import ob.unibanca.sicf.tarifarios.service.tarifarioemisor.ITarifarioEmisorService;
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
public class TarifarioEmisorRestController {
	
	private final ITarifarioEmisorService tarifarioEmisorService;
	
	public TarifarioEmisorRestController(ITarifarioEmisorService tarifarioEmisorService) {
		this.tarifarioEmisorService = tarifarioEmisorService;
	}
	
	@PreAuthorize("hasPermission('MANT_TAREMI','2')")
	@GetMapping("/tarifarios-emisores")
	public List<TarifarioEmisor> buscarTodosTarifariosEmisores() {
		return this.tarifarioEmisorService.buscarTodosTarifariosEmisores();
	}
	
	@PreAuthorize("hasPermission('MANT_TAREMI','1')")
	@PostMapping(value = "/tarifarios-emisores", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TarifarioEmisor registrarTarifarioEmisor(
			@Validated({IRegistro.class, Default.class}) @RequestBody TarifarioEmisor tarifarioEmisor) {
		return this.tarifarioEmisorService.registrarTarifarioEmisor(tarifarioEmisor);
	}
	
	@PreAuthorize("hasPermission('MANT_TAREMI','3')")
	@PutMapping(value = "/tarifarios-emisores/{idTarifarioEmisor}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TarifarioEmisor actualizarTarifarioEmisor(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioEmisor,
	                                       @Validated @RequestBody TarifarioEmisor tarifarioEmisor) {
		return this.tarifarioEmisorService.actualizarTarifarioEmisor(idTarifarioEmisor, tarifarioEmisor);
	}
	
	@PreAuthorize("hasPermission('MANT_TAREMI','4')")
	@DeleteMapping("/tarifarios-emisores/{idTarifarioEmisor}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTarifarioEmisor(@IdNumerico(maxRange = 9999) @PathVariable int idTarifarioEmisor) {
		this.tarifarioEmisorService.eliminarTarifarioEmisor(idTarifarioEmisor);
	}
	
}
