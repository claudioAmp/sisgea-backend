package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.ReglasCompensacion;
import ob.unibanca.sicf.mantenimientosgenerales.service.reglascompensacion.IReglasCompensacionService;

@Validated
@RestController
public class ReglasCompensacionRestController {
	
	private final IReglasCompensacionService reglasCompensacionService;
	
	public ReglasCompensacionRestController(IReglasCompensacionService reglasCompensacionService) {
		this.reglasCompensacionService = reglasCompensacionService;
	}
	
	@PreAuthorize("hasPermission('MANT_REGLAS_COMPENSACION', '2')")
	@GetMapping("/reglas-compensacion")
	public List<ReglasCompensacion> buscarTodos(){
		return this.reglasCompensacionService.buscarTodos();
	}
	
	@PreAuthorize("hasPermission('MANT_REGLAS_COMPENSACION', '1')")
	@PostMapping(value = "/reglas-compensacion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ReglasCompensacion registrarReglaCompensacion(@Validated({IRegistro.class, Default.class}) @RequestBody ReglasCompensacion reglasCompensacion) {
		return this.reglasCompensacionService.registrarReglaCompensacion(reglasCompensacion);
	}
	
	@PreAuthorize("hasPermission('MANT_REGLAS_COMPENSACION', '3')")
	@PutMapping(value = "/reglas-compensacion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReglasCompensacion actualizarReglaCompensacion(@Validated({IRegistro.class, Default.class}) @RequestBody ReglasCompensacion reglasCompensacion) {
		return this.reglasCompensacionService.actualizarReglaCompensacion(reglasCompensacion);
	}
	
	@PreAuthorize("hasPermission('MANT_REGLAS_COMPENSACION', '4')")
	@DeleteMapping(value = "/reglas-compensacion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarReglaCompensacion(@Validated({IRegistro.class, Default.class}) @RequestBody ReglasCompensacion reglasCompensacion) {
		this.reglasCompensacionService.eliminarReglaCompensacion(reglasCompensacion);
	}
	
}
