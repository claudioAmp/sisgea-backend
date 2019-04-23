package ob.unibanca.sicf.reportes.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

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

import ob.unibanca.sicf.reportes.model.Tabla;
import ob.unibanca.sicf.reportes.service.tabla.ITablaService;


@Validated
@RestController
public class TablaRestController {
	
	private final ITablaService tablaService;
	
	public TablaRestController(ITablaService tablaService) {
		this.tablaService = tablaService;
	}
	
	@GetMapping(value = "/tablas")
	public List<Tabla> buscarTodosCanales() {
		return this.tablaService.buscarTodos();
	}
	
	/*@PostMapping(value = "/tablas", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Canal registrarCanal(@Validated({IRegistro.class, Default.class}) @RequestBody Canal canal) {
		return this.canalService.registrarCanal(canal);
	}
	
	@PutMapping(value = "/canales/{idCanal}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Canal actualizarCanal(@IdNumerico(maxRange = 99) @PathVariable int idCanal,
	                             @Validated @RequestBody Canal canal) {
		return this.canalService.actualizarCanal(idCanal, canal);
	}
	
	@DeleteMapping(value = "/canales/{idCanal}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCanal(@IdNumerico(maxRange = 99) @PathVariable int idCanal) {
		this.canalService.eliminarCanal(idCanal);
	}*/
	
}
