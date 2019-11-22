package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN;
import ob.unibanca.sicf.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.bin.IBINService;
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
public class BINRestController {
	
	private final IBINService binService;
	
	public BINRestController(IBINService binService) {
		this.binService = binService;
	}
	
	@PreAuthorize("hasPermission('MANT_BIN', '2')")
	@GetMapping("/bins")
	public List<BIN> buscarTodosBINs() {
		return this.binService.buscarTodosBIN();
	}
	
	@PreAuthorize("hasPermission('MANT_BIN', '2')")
	@GetMapping("/bins/buscar")
	public List<BIN> buscarPorInstituciones(CriterioBusquedaInstitucion criterio) {
		return this.binService.buscarPorInstituciones(criterio);
	}
	
	@PreAuthorize("hasPermission('MANT_BIN', '1')")
	@PostMapping(value = "/bins", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public BIN registrarBIN(@Validated({IRegistro.class, Default.class}) @RequestBody BIN bin) {
		return this.binService.registrarBIN(bin);
	}
	
	@PreAuthorize("hasPermission('MANT_BIN', '3')")
	@PutMapping(value = "/bins/{idBIN}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BIN actualizarBIN(
			@IdCadena(minLength = 6, maxLength = 15, regexpPattern = "[0-9]+") @PathVariable String idBIN,
			@Validated @RequestBody BIN bin) {
		return this.binService.actualizarBIN(idBIN, bin);
	}
	
	@PreAuthorize("hasPermission('MANT_BIN', '4')")
	@DeleteMapping("/bins/{idBIN}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarBIN(
			@IdCadena(minLength = 6, maxLength = 15, regexpPattern = "[0-9]+") @PathVariable String idBIN) {
		this.binService.eliminarBIN(idBIN);
	}
}
