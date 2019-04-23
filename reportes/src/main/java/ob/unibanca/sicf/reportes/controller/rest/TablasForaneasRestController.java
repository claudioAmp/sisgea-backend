package ob.unibanca.sicf.reportes.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.reportes.model.TablasForaneas;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaTablasForaneas;
import ob.unibanca.sicf.reportes.service.tablasforaneas.ITablasForaneasService;

@Validated
@RestController
public class TablasForaneasRestController {
	
	private final ITablasForaneasService tablasForaneasService;
	
	public TablasForaneasRestController(ITablasForaneasService tablasForaneasService) {
		this.tablasForaneasService = tablasForaneasService;
	}
	
	@GetMapping(value = "/tablas-foraneas")
	public List<TablasForaneas> buscarTodosCanales() {
		return this.tablasForaneasService.buscarTodos();
	}
	
	@GetMapping(value = "/tablas-foraneas/buscar")
	public List<TablasForaneas> buscarTodosCanales(CriterioBusquedaTablasForaneas criterio) {
		return this.tablasForaneasService.buscarPorCriterios(criterio);
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
