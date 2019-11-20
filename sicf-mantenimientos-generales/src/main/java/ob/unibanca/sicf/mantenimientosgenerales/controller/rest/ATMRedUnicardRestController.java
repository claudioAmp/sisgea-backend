package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedUnicard;
import ob.unibanca.sicf.mantenimientosgenerales.service.atmredunicard.IATMRedUnicardService;
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
public class ATMRedUnicardRestController {
	
	private final IATMRedUnicardService atmRedUnicardService;
	
	public ATMRedUnicardRestController(IATMRedUnicardService atmRedUnicardService) {
		this.atmRedUnicardService = atmRedUnicardService;
	}
	
	@PreAuthorize("hasPermission('MANT_ATREUN', '2')")
	@GetMapping("/atms-redes-unicard")
	public List<ATMRedUnicard> buscarTodosATMsRedUnicard() {
		return this.atmRedUnicardService.buscarTodosATMsRedUnicard();
	}
	
	@PreAuthorize("hasPermission('MANT_ATREUN', '1')")
	@PostMapping(value = "/atms-redes-unicard", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ATMRedUnicard registrarATMRedUnicard(
			@Validated({IRegistro.class, Default.class}) @RequestBody ATMRedUnicard atmRedUnicard) {
		return this.atmRedUnicardService.registrarATMRedUnicard(atmRedUnicard);
	}
	
	@PreAuthorize("hasPermission('MANT_ATREUN', '3')")
	@PutMapping(value = "/atms-redes-unicard/{idATM}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ATMRedUnicard actualizarATMRedUnicard(@IdNumerico(maxRange = 99999) @PathVariable int idATM,
	                                             @Validated @RequestBody ATMRedUnicard atmRedUnicard) {
		return this.atmRedUnicardService.actualizarATMRedUnicard(idATM, atmRedUnicard);
	}
	
	@PreAuthorize("hasPermission('MANT_ATREUN', '4')")
	@DeleteMapping(value = "/atms-redes-unicard/{idATM}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarATMRedUnicard(@IdNumerico(maxRange = 99999) @PathVariable int idATM) {
		this.atmRedUnicardService.eliminarATMRedUnicard(idATM);
	}
}
