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
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;
import ob.unibanca.sicf.generadorconsultas.service.campoquery.*;




@Validated
@RestController
public class CampoQueryRestController {
	
	private final ICampoQueryService CampoQueryService;
	
	public CampoQueryRestController(ICampoQueryService CampoQueryService) {
		this.CampoQueryService = CampoQueryService;
	}
	
	@GetMapping(value = "/campos-query")
	public List<CampoQuery> buscarTodosCampoQuerys() {
		
		return this.CampoQueryService.buscarTodosCamposQuery();
		
	}
	@GetMapping(value = "/campos-query/buscar")
	public List<CampoQuery> buscarTodosCampoQuerys(CriterioBusquedaCampoQuery criterio) {
		return this.CampoQueryService.buscarPorCriteriosCamposQuery(criterio);
	}
	@PostMapping(value = "/campos-query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CampoQuery registrarCampoQuery(@Validated({IRegistro.class, Default.class}) @RequestBody CampoQuery CampoQuery) {
		return this.CampoQueryService.registrarCampoQuery(CampoQuery);
	}
	
	@PutMapping(value = "/campos-query/{idCampo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CampoQuery actualizarCampoQuery(@IdNumerico(maxRange = 99) @PathVariable int idCampoQuery,
	                             @Validated @RequestBody CampoQuery CampoQuery) {
		return this.CampoQueryService.actualizarCampoQuery(idCampoQuery, CampoQuery);
	}
	
	@DeleteMapping(value = "/campos-query/{idCampo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarCampoQuery(@IdNumerico(maxRange = 99) @PathVariable int idCampoQuery) {
		this.CampoQueryService.eliminarCampoQuery(idCampoQuery);
	}
}