package ob.unibanca.sicf.tarifario.controller;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifario.model.TipoTarifa;
import ob.unibanca.sicf.tarifario.service.tipotarifa.ITipoTarifaService;
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
public class TipoTarifaRestController {
	
	private final ITipoTarifaService tipoTarifaService;
	
	public TipoTarifaRestController(ITipoTarifaService tipoTarifaService) {
		this.tipoTarifaService = tipoTarifaService;
	}
	
	@GetMapping("/tipoTarifa")
	public List<TipoTarifa> buscarTodosTipoTarifa() {
		return this.tipoTarifaService.buscarTodosTipoTarifa();
	}
	
	@PostMapping(value = "/tipoTarifa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TipoTarifa registrarTipoTarifa(
			@Validated({IRegistro.class, Default.class}) @RequestBody TipoTarifa tipoTarifa) {
		return this.tipoTarifaService.registrarTipoTarifa(tipoTarifa);
	}
	
	@PutMapping(value = "/tipoTarifa/{idTarifa}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TipoTarifa actualizarTipoTarifa(@IdNumerico(maxRange = 99) @PathVariable int idTarifa,
	                                       @Validated @RequestBody TipoTarifa tipoTarifa) {
		return this.tipoTarifaService.actualizarTipoTarifa(idTarifa, tipoTarifa);
	}
	
	@DeleteMapping("/tipoTarifa/{idTarifa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTipoTarifa(@IdNumerico(maxRange = 99) @PathVariable int idTarifa) {
		this.tipoTarifaService.eliminarTipoTarifa(idTarifa);
	}
	
}
