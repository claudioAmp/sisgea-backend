package ob.unibanca.sicf.consultasgenerales.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiosbs.TipoCambioSBS;
import ob.unibanca.sicf.consultasgenerales.service.tipocambiosbs.ITipoCambioSBSService;

@RestController
public class TipoCambioSBSRestController {

	private final ITipoCambioSBSService tipoCambioMembService;
	
	public TipoCambioSBSRestController(ITipoCambioSBSService tipoCambioMembService) {
		this.tipoCambioMembService = tipoCambioMembService;
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '2')")
	@GetMapping("/tipos-cambio-sbs")
	public List<TipoCambioSBS> buscarTodosTipoCambioSBS() {
		return this.tipoCambioMembService.buscarTodosTipoCambio();
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '1')")
	@PostMapping(value = "/tipos-cambio-sbs", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TipoCambioSBS registrarTipoCambioSBS(@Validated({IRegistro.class, Default.class}) @RequestBody TipoCambioSBS tipoCambio) {
		return this.tipoCambioMembService.registrarTipoCambio(tipoCambio);
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '3')")
	@PutMapping(value = "/tipos-cambio-sbs", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TipoCambioSBS actualizarTipoCambioSBS(@Validated @RequestBody TipoCambioSBS tipoCambio) {
		return this.tipoCambioMembService.actualizarTipoCambio(tipoCambio);
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '4')")
	@DeleteMapping("/tipos-cambio-sbs")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTipoCambioSBS(@Validated @RequestBody TipoCambioSBS tipoCambio) {
		this.tipoCambioMembService.eliminarTipoCambio(tipoCambio);
	}
}
