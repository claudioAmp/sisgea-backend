package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import edu.taller.sisgea.mantenimientosgenerales.model.ParametroConsulta;
import edu.taller.sisgea.mantenimientosgenerales.service.parametroconsulta.IParametroConsultaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class ParametroConsultaRestController {
	
	private final IParametroConsultaService parametroConsultaService;
	
	public ParametroConsultaRestController(IParametroConsultaService parametroConsultaService) {
		this.parametroConsultaService = parametroConsultaService;
	}
	
	@GetMapping("/parametros-consulta")
	public List<ParametroConsulta> buscarTodosParametrosConsulta() {
		return this.parametroConsultaService.buscarTodosParametrosConsulta();
	}
	
}