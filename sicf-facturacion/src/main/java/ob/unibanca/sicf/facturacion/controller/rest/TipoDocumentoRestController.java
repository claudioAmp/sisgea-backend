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
import ob.unibanca.sicf.facturacion.model.TipoDocumento;
import ob.unibanca.sicf.facturacion.service.tipodocumento.ITipoDocumentoService;

@Validated
@RestController
public class TipoDocumentoRestController {
	private final ITipoDocumentoService tipoDocumentoService;
	
	public TipoDocumentoRestController(ITipoDocumentoService tipoDocumentoService) {
		this.tipoDocumentoService = tipoDocumentoService;
	}
	
	@PreAuthorize("hasPermission('MANT_TIPO_DOCU', '2')")
	@GetMapping("/tipoDocumento")
	public List<TipoDocumento> buscarTodosTipoDocumento(){
		return this.tipoDocumentoService.buscarTodosTipoDocumento();
	}
	
	@PreAuthorize("hasPermission('MANT_TIPO_DOCU', '1')")
	@PostMapping(value = "/tipoDocumento", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TipoDocumento registrarTipoDocumento(
			@Validated({IRegistro.class,Default.class}) 
			@RequestBody TipoDocumento tipoDocumento) {
		return this.tipoDocumentoService.registrarTipoDocumento(tipoDocumento);
	}
	
	@PreAuthorize("hasPermission('MANT_TIPO_DOCU', '3')")
	@PutMapping(value = "/tipoDocumento/{idDocumento}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TipoDocumento actualizarTipoDocumento(
			@IdNumerico(maxRange = 99) @PathVariable int idDocumento,
			@Validated @RequestBody TipoDocumento tipoDocumento) {
		return this.tipoDocumentoService.actualizarTipoDocumento(idDocumento, tipoDocumento);
	}
	
	@PreAuthorize("hasPermission('MANT_TIPO_DOCU', '4')")
	@DeleteMapping("/tipoDocumento/{idDocumento}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTipoDocumento (@IdNumerico(maxRange = 99) @PathVariable int idDocumento) {
		this.tipoDocumentoService.eliminarTipoDocumento(idDocumento);
	}
}
