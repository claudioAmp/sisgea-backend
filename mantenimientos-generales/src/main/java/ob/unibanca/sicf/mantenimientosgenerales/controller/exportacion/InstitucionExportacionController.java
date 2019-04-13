package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.institucion.IInstitucionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import java.util.HashMap;

import java.util.List;

@Validated
@Controller
public class InstitucionExportacionController {
	
	private final IInstitucionService institucionService;
	
	public InstitucionExportacionController(IInstitucionService institucionService) {
		this.institucionService = institucionService;
	}
	
	@GetMapping(value = "/instituciones", params ="accion=exportar")
	public ModelAndView exportarInstitucion(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Institucion> lista = institucionService.buscarTodosInstituciones();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientos/institucion");
      model.addAttribute("name", "Reporte Institución");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
