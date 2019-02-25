package ob.unibanca.sicf.mantenimientosgenerales.controller.restcontroller;

import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.institucion.IInstitucionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitucionRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(InstitucionRestController.class);
	private final IInstitucionService institucionService;
	
	public InstitucionRestController(IInstitucionService institucionService) {
		this.institucionService = institucionService;
	}
	
	@GetMapping(value = "/instituciones")
	public List<Institucion> buscarTodosInstituciones() {
		logger.debug("Se recibe la petición de retornar todas las instituciones");
		return this.institucionService.buscarTodosInstituciones();
	}
	
	@PostMapping(value = "/instituciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void registrarInstitucion(@RequestBody Institucion institucion) {
		logger.debug("Se recibe la petición de registrar la institucion {}", institucion);
		this.institucionService.registrarInstitucion(institucion);
	}
	
	@PutMapping(value = "/instituciones/{idInstitucion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void actualizarInstitucion(@PathVariable int idInstitucion, @RequestBody Institucion institucion) {
		logger.debug("Se recibe la petición de actualizar la institución {} identificado con el id {}", institucion,
		             idInstitucion); this.institucionService.actualizarInstitucion(idInstitucion, institucion);
	}
	
	@DeleteMapping(value = "/instituciones/{idInstitucion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarInstitucion(@PathVariable int idInstitucion) {
		logger.debug("Se recibe la petición de eliminar la institución identificada con el id {}", idInstitucion);
		this.institucionService.eliminarInstitucion(idInstitucion);
	}
}
