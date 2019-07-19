package ob.unibanca.sicf.generadorconsultas.controller.rest;


import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.service.generarconsulta.IGenerarConsultaService;
@Validated
@RestController
public class GenerarConsultaRestController {
	
	private final IGenerarConsultaService generarConsultaService;
	
	public GenerarConsultaRestController(IGenerarConsultaService generarConsultaService) {
		this.generarConsultaService = generarConsultaService;
	}
	

	@PostMapping(value = "/generar-consulta", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public String generar(@RequestBody Reporte reporteEstado) {
		return this.generarConsultaService.generarConsulta(reporteEstado);
	}
}
