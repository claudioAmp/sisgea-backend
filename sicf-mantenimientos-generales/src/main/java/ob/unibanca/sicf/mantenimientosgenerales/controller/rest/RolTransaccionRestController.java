package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.RolTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.roltransaccion.IRolTransaccionService;

@Validated
@RestController
public class RolTransaccionRestController {

	private final IRolTransaccionService rolTransaccionService;
	
	public RolTransaccionRestController(IRolTransaccionService rolTransaccionService) {
		this.rolTransaccionService = rolTransaccionService;
	}
	
	@GetMapping(value="/roles-transacciones")
	public List<RolTransaccion> buscarTodosRolesTransacciones(){
		return this.rolTransaccionService.buscarTodosRolesTransacciones();
	}
}
