package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.unibanca.sicf.mantenimientosgenerales.model.ParametroConsulta;
import ob.unibanca.sicf.mantenimientosgenerales.service.parametroconsulta.IParametroConsultaService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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