package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.service.tipocuentacompensacion.ITipoCuentaCompensacionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.mantenimientosgenerales.model.TipoCuentaCompensacion;

@Validated
@RestController
public class TipoCuentaCompensacionRestController {

	private final ITipoCuentaCompensacionService tipoCuentaCompensacionService;
	
	public TipoCuentaCompensacionRestController(ITipoCuentaCompensacionService tipoCuentaCompensacionService) {
		this.tipoCuentaCompensacionService = tipoCuentaCompensacionService;
	}	
	
	@GetMapping("/tipos-cuentas-compensaciones")
	public List<TipoCuentaCompensacion> buscarTodosTiposCuentaCompensacion(){
		return this.tipoCuentaCompensacionService.buscarTodosTiposCuentaCompensacion();
	}
	
}
