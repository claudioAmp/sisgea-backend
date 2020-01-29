package ob.unibanca.sicf.facturacion.controller.rest;

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
import ob.unibanca.sicf.facturacion.model.TipoNota;
import ob.unibanca.sicf.facturacion.service.tiponota.ITipoNotaService;

@Validated
@RestController
public class TipoNotaRestController {
	private final ITipoNotaService tipoNotaService;

	public TipoNotaRestController(ITipoNotaService tipoNotaService) {
		this.tipoNotaService = tipoNotaService;
	}

	@PreAuthorize("hasPermission('MANT_TIPO_NOTA', '2')")
	@GetMapping("/tipoNota")
	public List<TipoNota> buscarTodosTipoNota() {
		return this.tipoNotaService.buscarTodosTipoNota();
	}

	@PreAuthorize("hasPermission('MANT_TIPO_NOTA', '1')")
	@PostMapping(value = "/tipoNota", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TipoNota registarTipoNota(@Validated({ IRegistro.class, Default.class }) @RequestBody TipoNota tipoNota) {
		return this.tipoNotaService.registrarTipoNota(tipoNota);
	}
	@PreAuthorize("hasPermission('MANT_TIPO_NOTA', '3')")
	@PutMapping(value = "/tipoNota/origenNota/{idOrigenNota}/nota/{idNota}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TipoNota actualizarTipoNota(@IdNumerico(maxRange = 9) @PathVariable int idOrigenNota,
			@IdNumerico(maxRange = 99) @PathVariable int idNota,
			@Validated @RequestBody TipoNota tipoNota) {
			return this.actualizarTipoNota(idOrigenNota, idNota, tipoNota);
	}
	
	@PreAuthorize("hasPermission('MANT_TIPO_NOTA', '4')")
	@DeleteMapping("/tipoNota/origenNota/{idOrigenNota}/nota/{idNota}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTipoNota(@IdNumerico(maxRange = 9) @PathVariable int idOrigenNota,
			@IdNumerico(maxRange = 99) @PathVariable int idNota) {
		this.tipoNotaService.eliminarTipoNota(idOrigenNota, idNota);
	}
}
