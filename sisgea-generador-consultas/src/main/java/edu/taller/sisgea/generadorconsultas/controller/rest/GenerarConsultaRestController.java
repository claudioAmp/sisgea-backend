package edu.taller.sisgea.generadorconsultas.controller.rest;

import edu.taller.sisgea.generadorconsultas.model.Reporte;
import edu.taller.sisgea.generadorconsultas.service.generarconsulta.IGenerarConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ob.commons.truncadorpan.decisor.IVisualizacionPANService;

@Validated
@RestController
public class GenerarConsultaRestController {
	
	private @Autowired final IGenerarConsultaService generarConsultaService;
	private @Autowired final IVisualizacionPANService visualizacionPANService;
	
	public GenerarConsultaRestController(IGenerarConsultaService generarConsultaService,IVisualizacionPANService visualizacionPANService) {
		this.generarConsultaService = generarConsultaService;
		this.visualizacionPANService = visualizacionPANService;
	}
	

	@PostMapping(value = "/generar-consulta", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public String generar(@RequestBody Reporte reporteEstado) {
		reporteEstado.setVisualiza(this.visualizacionPANService.puedeVisualizarPAN());
		return this.generarConsultaService.generarConsulta(reporteEstado);
	}
}
