package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.Canal;
import ob.unibanca.sicf.mantenimientosgenerales.service.canal.ICanalService;
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
public class CanalRestController {
	
	private final ICanalService canalService;
	
	public CanalRestController(ICanalService canalService) {
		this.canalService = canalService;
	}
	
	@PreAuthorize("hasPermission('MANT_CANAL', '2')")
	@GetMapping(value = "/canales")
	public List<Canal> buscarTodosCanales() {
		return this.canalService.buscarTodosCanales();
	}
	
	@PreAuthorize("hasPermission('MANT_CANAL', '1')")
	@PostMapping(value = "/canales", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Canal registrarCanal(@Validated({IRegistro.class, Default.class}) @RequestBody Canal canal) {
		return this.canalService.registrarCanal(canal);
	}
	
	@PreAuthorize("hasPermission('MANT_CANAL', '3')")
	@PutMapping(value = "/canales/{idCanal}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Canal actualizarCanal(@IdNumerico(maxRange = 99) @PathVariable int idCanal,
	                             @Validated @RequestBody Canal canal) {
		return this.canalService.actualizarCanal(idCanal, canal);
	}
	
	@PreAuthorize("hasPermission('MANT_CANAL', '4')")
	@DeleteMapping(value = "/canales/{idCanal}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCanal(@IdNumerico(maxRange = 99) @PathVariable int idCanal) {
		this.canalService.eliminarCanal(idCanal);
	}
}
