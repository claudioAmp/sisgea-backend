package ob.unibanca.sicf.generadorconsultas.controller.rest;

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

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaFiltro;
import ob.unibanca.sicf.generadorconsultas.service.filtro.*;




@Validated
@RestController
public class FiltroRestController {
	
	private final IFiltroService filtroService;
	
	public FiltroRestController(IFiltroService FiltroService) {
		this.filtroService = FiltroService;
	}
	
	@GetMapping(value = "/filtros")
	public List<Filtro> buscarTodosFiltros() {
		
		return this.filtroService.buscarTodosFiltro();
		
	}
	@GetMapping(value = "/filtros/buscar")
	public List<Filtro> buscarTodosFiltros(CriterioBusquedaFiltro criterio) {
		return this.filtroService.buscarPorCriteriosFiltro(criterio);
	}
	@PostMapping(value = "/filtros", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Filtro registrarFiltro(@Validated({IRegistro.class, Default.class}) @RequestBody Filtro filtro) {
		return this.filtroService.registrarFiltro(filtro);
	}
	
	@PutMapping(value = "/filtros/{idFiltroCampo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Filtro actualizarFiltro(@IdNumerico(maxRange = 99999) @PathVariable Integer idFiltroCampo,
	                             @Validated @RequestBody Filtro filtro) {
		return this.filtroService.actualizarFiltro(idFiltroCampo, filtro);
	}
	
	@DeleteMapping(value = "/filtros/{idFiltroCampo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarFiltro(@IdNumerico(maxRange = 99999) @PathVariable Integer idFiltroCampo) {
		this.filtroService.eliminarFiltro(idFiltroCampo);
	}
}