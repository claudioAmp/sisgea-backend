package ob.unibanca.sicf.generadorconsultas.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.generadorconsultas.model.OperadorTipoDato;
import ob.unibanca.sicf.generadorconsultas.model.OperadoresTipoDato;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaOperadorTipoDato;
import ob.unibanca.sicf.generadorconsultas.service.operadortipodato.IOperadorTipoDatoService;


import java.util.List;

@Validated
@RestController
public class OperadorTipoDatoRestController {

	private final IOperadorTipoDatoService operadorTipoDatoService;
	public OperadorTipoDatoRestController(IOperadorTipoDatoService operadorTipoDatoService) {
		this.operadorTipoDatoService = operadorTipoDatoService;
	}
	
	@GetMapping(value = "/operadores-tipo-dato")
	public List<OperadorTipoDato> buscarTodosOperadorTipoDatoes() {
		return this.operadorTipoDatoService.buscarTodosOperadorTipoDato();
	}
	
	@GetMapping(value = "/operadores-tipo-dato/buscar")
	public List<OperadorTipoDato> buscarTodosOperadorTipoDatoes(CriterioBusquedaOperadorTipoDato criterio) {
		return this.operadorTipoDatoService.buscarPorCriterioOperadorTipoDato(criterio);
	}
	
	@GetMapping(value = "/operadores-tipo-dato/grouping/tipo-dato")
	public List<OperadoresTipoDato> buscarPorGruposTipoDato(CriterioBusquedaOperadorTipoDato criterio) {
		return this.operadorTipoDatoService.buscarPorGruposTipoDato(criterio);
	}
	
}
