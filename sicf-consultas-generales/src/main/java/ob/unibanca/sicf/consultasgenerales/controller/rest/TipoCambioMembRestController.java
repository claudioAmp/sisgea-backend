package ob.unibanca.sicf.consultasgenerales.controller.rest;

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
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.consultasgenerales.model.tipocambiomemb.TipoCambioMemb;
import ob.unibanca.sicf.consultasgenerales.service.tipocambiomemb.ITipoCambioMembService;

@RestController
public class TipoCambioMembRestController {
	
	private final ITipoCambioMembService tipoCambioMembService;
	
	public TipoCambioMembRestController(ITipoCambioMembService tipoCambioMembService) {
		this.tipoCambioMembService = tipoCambioMembService;
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '2')")
	@GetMapping("/tipos-cambio-memb")
	public List<TipoCambioMemb> buscarTodosTipoCambioMembs() {
		return this.tipoCambioMembService.buscarTodosTipoCambio();
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '1')")
	@PostMapping(value = "/tipos-cambio-memb", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TipoCambioMemb registrarTipoCambioMemb(@Validated({IRegistro.class, Default.class}) @RequestBody TipoCambioMemb tipoCambio) {
		return this.tipoCambioMembService.registrarTipoCambio(tipoCambio);
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '3')")
	@PutMapping(value = "/tipos-cambio-memb", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TipoCambioMemb actualizarTipoCambioMemb(@Validated @RequestBody TipoCambioMemb tipoCambio) {
		return this.tipoCambioMembService.actualizarTipoCambio(tipoCambio);
	}
	
	@PreAuthorize("hasPermission('CON_TIPOCAMBIO', '4')")
	@DeleteMapping("/tipos-cambio-memb")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarTipoCambioMemb(@Validated @RequestBody TipoCambioMemb tipoCambio) {
		this.tipoCambioMembService.eliminarTipoCambio(tipoCambio);
	}
}	
