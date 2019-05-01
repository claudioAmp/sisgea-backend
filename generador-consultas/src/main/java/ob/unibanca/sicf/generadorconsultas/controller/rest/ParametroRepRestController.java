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
import ob.unibanca.sicf.generadorconsultas.model.ParametroRep;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaParametroRep;
import ob.unibanca.sicf.generadorconsultas.service.parametrorep.IParametroRepService;




@Validated
@RestController
public class ParametroRepRestController {
	
	private final IParametroRepService parametroRepService;
	
	public ParametroRepRestController(IParametroRepService parametroRepService) {
		this.parametroRepService = parametroRepService;
	}
	
	@GetMapping(value = "/parametros-rep")
	public List<ParametroRep> buscarTodosParametrosRep() {
		return this.parametroRepService.buscarTodosParametrosRep();
	}
	@GetMapping(value = "/parametros-rep/buscar")
	public List<ParametroRep> buscarTodosParametrosRep(CriterioBusquedaParametroRep criterio) {
		return this.parametroRepService.buscarPorCriteriosParametroRep(criterio);
	}
	@PostMapping(value = "/parametros-rep", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ParametroRep registrarParametroRep(@Validated({IRegistro.class, Default.class}) @RequestBody ParametroRep parametroRep) {
		return this.parametroRepService.registrarParametroRep(parametroRep);
	}
	
	@PutMapping(value = "/parametros-rep/{idParametroRep}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ParametroRep actualizarParametroRep(@IdNumerico(maxRange = 99) @PathVariable int idParametroRep,
	                             @Validated @RequestBody ParametroRep parametroRep) {
		return this.parametroRepService.actualizarParametroRep(idParametroRep, parametroRep);
	}
	
	@DeleteMapping(value = "/parametros-rep/{idParametroRep}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarParametroRep(@IdNumerico(maxRange = 99) @PathVariable int idParametroRep) {
		this.parametroRepService.eliminarParametroRep(idParametroRep);
	}
}