package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.institucion.IInstitucionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	private final IInstitucionService institucionService;
	
	public InstitucionRestController(IInstitucionService institucionService) {
		this.institucionService = institucionService;
	}
	
	@PreAuthorize("hasPermission('MANT_INSTIT', '2')")
	@GetMapping(value = "/instituciones")
	public List<Institucion> buscarTodosInstituciones() {
		return this.institucionService.buscarTodosInstituciones();
	}
	
	@PreAuthorize("hasPermission('MANT_INSTIT', '2')")
	@GetMapping(value = "/instituciones/buscar")
	public List<Institucion> buscarPorCriterio(CriterioBusquedaInstitucion criterio) {
		return this.institucionService.buscarPorCriterios(criterio);
	}
	
	@PreAuthorize("hasPermission('MANT_INSTIT', '1')")
	@PostMapping(value = "/instituciones", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Institucion registrarInstitucion(
			@Validated({IRegistro.class, Default.class}) @RequestBody Institucion institucion) {
		return this.institucionService.registrarInstitucion(institucion);
	}
	
	@PreAuthorize("hasPermission('MANT_INSTIT', '3')")
	@PutMapping(value = "/instituciones/{idInstitucion}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Institucion actualizarInstitucion(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion,
	                                         @Validated @RequestBody Institucion institucion) {
		return this.institucionService.actualizarInstitucion(idInstitucion, institucion);
	}
	
	@PreAuthorize("hasPermission('MANT_INSTIT', '4')")
	@DeleteMapping(value = "/instituciones/{idInstitucion}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarInstitucion(@IdNumerico(maxRange = 99999) @PathVariable int idInstitucion) {
		this.institucionService.eliminarInstitucion(idInstitucion);
	}
}
