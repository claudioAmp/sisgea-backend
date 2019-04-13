package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.TipoCuentaCompensacion;
import ob.unibanca.sicf.mantenimientosgenerales.service.tipocuentacompensacion.ITipoCuentaCompensacionService;

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
