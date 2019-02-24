package ob.unibanca.sicf.mantenimientosgenerales.controller.restcontroller;

import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.institucion.IInstitucionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento/general/")
public class InstitucionRestController {
	
	private final IInstitucionService institucionService;
	
	public InstitucionRestController(IInstitucionService institucionService) {
		this.institucionService = institucionService;
	}
	
	@GetMapping("instituciones")
	public List<Institucion> buscarTodosInstituciones() {
		return this.institucionService.buscarTodosInstituciones();
	}
}
