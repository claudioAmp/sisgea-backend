package ob.unibanca.sicf.tarifarios.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.validation.validation.IdCadena;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.tarifarios.model.GrupoBINTarifa;
import ob.unibanca.sicf.tarifarios.service.grupobintarifa.IGrupoBINTarifaService;

@RestController
public class GrupoBINTarifaRestController {
	
	private final IGrupoBINTarifaService grupoBINTarifaService;
	
	public GrupoBINTarifaRestController(IGrupoBINTarifaService grupoBINTarifaService) {
		this.grupoBINTarifaService = grupoBINTarifaService;
	}
	
	@GetMapping("/grupo-bin-tarifa")
	public List<GrupoBINTarifa> buscarTodosGruposBIN(){
		return this.grupoBINTarifaService.buscarTodosGruposBIN();
	}
	
	@GetMapping(value = "/bins/{idBIN}/grupo-bin-tarifa",
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<GrupoBINTarifa> buscarGrupoBINTarifaPorBIN(
			@IdCadena(maxLength = 11) @PathVariable String idBIN){
		return this.grupoBINTarifaService.buscarGrupoBINTarifaPorBIN(idBIN);
	}
	
	@PostMapping(value = "/bins/{idBIN}/grupo-bin-tarifa",
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public GrupoBINTarifa registrarGrupoBINTarifa(@IdCadena(maxLength = 11) @PathVariable String idBIN,
												  @Validated({IRegistro.class, Default.class}) @RequestBody
												  GrupoBINTarifa grupoBINTarifa) {
		return this.grupoBINTarifaService.registrarGrupoBINTarifa(idBIN, grupoBINTarifa);
	}
	
	@PostMapping(value = "/bins/{idBIN}/grupo-bin-tarifa/{idGrupoBIN}",
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public GrupoBINTarifa actualizarGrupoBINTarifa(@IdNumerico(maxRange = 9999) int idGrupoBIN,
												   @IdCadena(maxLength = 11) @PathVariable String idBIN,
												   @Validated @RequestBody GrupoBINTarifa grupoBINTarifa) {
		return this.grupoBINTarifaService.actualizarGrupoBINTarifa(idGrupoBIN, idBIN, grupoBINTarifa);
	}
	
	@DeleteMapping(value = "/bins/{idBIN}/grupo-bin-tarifa/{idGrupoBINTarifa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarGrupoBINTarifa(@IdNumerico(maxRange = 9999) int idGrupoBIN,
									   @IdCadena(maxLength = 11) @PathVariable String idBIN) {
		this.grupoBINTarifaService.eliminarGrupoBINTarifa(idGrupoBIN, idBIN);
	}
											
}
