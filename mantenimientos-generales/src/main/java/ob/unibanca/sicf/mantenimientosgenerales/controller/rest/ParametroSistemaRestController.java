package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.ParametroSistema;
import ob.unibanca.sicf.mantenimientosgenerales.service.parametroSistema.IParametroSistemaService;

@Validated
@RestController
public class ParametroSistemaRestController {

	private final IParametroSistemaService parametroSistemaService;
	
	public ParametroSistemaRestController(IParametroSistemaService parametroSistemaService) {
		this.parametroSistemaService = parametroSistemaService;
	}
	
	@GetMapping("/parametros-sistema")
	public List<ParametroSistema> buscarTodosParametrosSistema(){
		return this.parametroSistemaService.buscarTodosParametrosSistema();
	}
	
	@PutMapping(value = "/parametros-sistema", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ParametroSistema actualizarParametroSistema(@Validated @RequestBody ParametroSistema parametroSistema) {
		return this.parametroSistemaService.actualizarParametroSistema(parametroSistema);
	}
}
