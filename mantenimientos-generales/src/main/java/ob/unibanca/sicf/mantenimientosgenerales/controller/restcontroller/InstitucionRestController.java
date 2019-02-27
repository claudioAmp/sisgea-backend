package ob.unibanca.sicf.mantenimientosgenerales.controller.restcontroller;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.institucion.IInstitucionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import javax.validation.groups.Default;
import java.util.List;

@Validated
@RestController
public class InstitucionRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(InstitucionRestController.class);
	private final IInstitucionService institucionService;
	
	public InstitucionRestController(IInstitucionService institucionService) {
		this.institucionService = institucionService;
	}
	
	@GetMapping(value = "/instituciones")
	public List<Institucion> buscarTodosInstituciones() {
		logger.debug("Se recibe la petición de retornar todas las instituciones"); return this.institucionService.buscarTodosInstituciones();
	}
	
	@PostMapping(value = "/instituciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void registrarInstitucion(
			@Validated({IRegistro.class, Default.class}) @RequestBody Institucion institucion) {
		logger.debug("Se recibe la petición de registrar la institucion {}", institucion);
		this.institucionService.registrarInstitucion(institucion);
	}
	
	@PutMapping(value = "/instituciones/{idInstitucion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void actualizarInstitucion(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion,
	                                  @Validated @RequestBody Institucion institucion) {
		logger.debug("Se recibe la petición de actualizar la institución {} identificado con el id {}", institucion,
		             idInstitucion); this.institucionService.actualizarInstitucion(idInstitucion, institucion);
	}
	
	@DeleteMapping(value = "/instituciones/{idInstitucion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarInstitucion(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion) {
		logger.debug("Se recibe la petición de eliminar la institución identificada con el id {}", idInstitucion);
		this.institucionService.eliminarInstitucion(idInstitucion);
	}
}
