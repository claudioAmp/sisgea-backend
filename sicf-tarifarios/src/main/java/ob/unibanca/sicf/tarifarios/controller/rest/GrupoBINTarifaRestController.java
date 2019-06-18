package ob.unibanca.sicf.tarifarios.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.tarifarios.model.GrupoBINTarifa;
import ob.unibanca.sicf.tarifarios.service.grupobintarifa.IGrupoBINTarifaService;

@RestController
public class GrupoBINTarifaRestController {
	
	private final IGrupoBINTarifaService grupoBINTarifaService;
	
	public GrupoBINTarifaRestController(IGrupoBINTarifaService grupoBINTarifaService) {
		this.grupoBINTarifaService = grupoBINTarifaService;
	}
	
	@PreAuthorize("hasPermission('MANT_TAREMI','1,3')")
	@GetMapping("/grupos-bines-tarifas")
	public List<GrupoBINTarifa> buscarTodosGruposBIN(){
		return this.grupoBINTarifaService.buscarTodosGruposBIN();
	}
	
	@PreAuthorize("hasPermission('MANT_TAREMI','1,3')")
	@GetMapping("/grupos-bines-tarifas/grouping")
	public List<GrupoBINTarifa> buscarTodosGruposBINAgrupado(){
		return this.grupoBINTarifaService.buscarTodosGruposBINAgrupado();
	}
	
	/*
	@GetMapping(value = "/bins/{idBIN}/grupos-bines-tarifas",
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<GrupoBINTarifa> buscarGrupoBINTarifaPorBIN(
			@IdCadena(maxLength = 11) @PathVariable String idBIN){
		return this.grupoBINTarifaService.buscarGrupoBINTarifaPorBIN(idBIN);
	}
	
	@PostMapping(value = "/bins/{idBIN}/grupos-bines-tarifas",
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public GrupoBINTarifa registrarGrupoBINTarifa(@IdCadena(maxLength = 11) @PathVariable String idBIN,
												  @Validated({IRegistro.class, Default.class}) @RequestBody
												  GrupoBINTarifa grupoBINTarifa) {
		return this.grupoBINTarifaService.registrarGrupoBINTarifa(idBIN, grupoBINTarifa);
	}
	
	@PostMapping(value = "/bins/{idBIN}/grupos-bins-tarifas/{idGrupoBIN}",
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public GrupoBINTarifa actualizarGrupoBINTarifa(@IdNumerico(maxRange = 9999) int idGrupoBIN,
												   @IdCadena(maxLength = 11) @PathVariable String idBIN,
												   @Validated @RequestBody GrupoBINTarifa grupoBINTarifa) {
		return this.grupoBINTarifaService.actualizarGrupoBINTarifa(idGrupoBIN, idBIN, grupoBINTarifa);
	}
	
	@DeleteMapping(value = "/bins/{idBIN}/grupos-bins-tarifas/{idGrupoBINTarifa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarGrupoBINTarifa(@IdNumerico(maxRange = 9999) int idGrupoBIN,
									   @IdCadena(maxLength = 11) @PathVariable String idBIN) {
		this.grupoBINTarifaService.eliminarGrupoBINTarifa(idGrupoBIN, idBIN);
	}*/
											
}
