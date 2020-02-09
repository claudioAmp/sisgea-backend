package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.RolTransaccion;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.mantenimientosgenerales.service.roltransaccion.IRolTransaccionService;

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
