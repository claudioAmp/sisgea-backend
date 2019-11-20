package ob.unibanca.sicf.facturacion.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.facturacion.model.Portafolio;
import ob.unibanca.sicf.facturacion.service.portafolio.IPortafolioService;
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
public class PortafolioRestController {
	
	private final IPortafolioService portafolioService;
	
	public PortafolioRestController(IPortafolioService portafolioService) {
		this.portafolioService = portafolioService;
	}
	
	@GetMapping("/portafolios")
	public List<Portafolio> buscarTodosPortafolios() {
		return this.portafolioService.buscarTodosPortafolios();
	}
	
	@PostMapping(value = "/portafolios", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Portafolio registrarPortafolio(
			@Validated({IRegistro.class, Default.class}) @RequestBody Portafolio portafolio) {
		return this.portafolioService.registrarPortafolio(portafolio);
	}
	
	@PutMapping(value = "/portafolios/{idPortafolio}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Portafolio actualizarPortafolio(@IdNumerico(maxRange = 999) @PathVariable int idPortafolio,
	                                       @Validated @RequestBody Portafolio portafolio) {
		return this.portafolioService.actualizarPortafolio(idPortafolio, portafolio);
	}
	
	@DeleteMapping("/portafolios/{idPortafolio}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarPortafolio(@IdNumerico(maxRange = 999) @PathVariable int idPortafolio) {
		this.portafolioService.eliminarPortafolio(idPortafolio);
	}
}
