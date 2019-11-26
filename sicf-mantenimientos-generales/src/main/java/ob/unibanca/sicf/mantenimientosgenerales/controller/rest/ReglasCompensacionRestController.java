package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ob.unibanca.sicf.mantenimientosgenerales.model.ReglasCompensacion;
import ob.unibanca.sicf.mantenimientosgenerales.service.reglascompensacion.IReglasCompensacionService;

@Validated
@RestController
public class ReglasCompensacionRestController {
	
	private final IReglasCompensacionService reglasCompensacionService;
	
	public ReglasCompensacionRestController(IReglasCompensacionService reglasCompensacionService) {
		this.reglasCompensacionService = reglasCompensacionService;
	}
	
	@PreAuthorize("hasPermission('MANT_REGCOMPFOND', '2')")
	@GetMapping("/reglas-compensacion")
	public List<ReglasCompensacion> buscarTodos(){
		return this.reglasCompensacionService.buscarTodos();
	}
	
}
