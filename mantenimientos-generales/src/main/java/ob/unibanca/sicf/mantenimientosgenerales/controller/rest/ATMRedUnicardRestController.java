package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedUnicard;
import ob.unibanca.sicf.mantenimientosgenerales.service.atmredunicard.IATMRedUnicardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class ATMRedUnicardRestController {
	
	private final IATMRedUnicardService atmRedUnicardService;
	
	public ATMRedUnicardRestController(IATMRedUnicardService atmRedUnicardService) {
		this.atmRedUnicardService = atmRedUnicardService;
	}
	
	@GetMapping("/atms-redes-unicard")
	public List<ATMRedUnicard> buscarTodosATMsRedUnicard() {
		return this.atmRedUnicardService.buscarTodosATMsRedUnicard();
	}
	
	@PostMapping(value = "/atms-redes-unicard", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ATMRedUnicard registrarATMRedUnicard(
			@Validated({IRegistro.class, Default.class}) @RequestBody ATMRedUnicard atmRedUnicard) {
		return this.atmRedUnicardService.registrarATMRedUnicard(atmRedUnicard);
	}
	
	@PutMapping(value = "/atms-redes-unicard/{idATM}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ATMRedUnicard actualizarATMRedUnicard(@IdNumerico(maxRange = 99999) @PathVariable int idATM,
	                                             @Validated @RequestBody ATMRedUnicard atmRedUnicard) {
		return this.atmRedUnicardService.actualizarATMRedUnicard(idATM, atmRedUnicard);
	}
	
	@DeleteMapping(value = "/atms-redes-unicard/{idATM}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarATMRedUnicard(@IdNumerico(maxRange = 99999) @PathVariable int idATM) {
		this.atmRedUnicardService.eliminarATMRedUnicard(idATM);
	}
	
}
