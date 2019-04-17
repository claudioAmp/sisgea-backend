package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.Origen;
import ob.unibanca.sicf.mantenimientosgenerales.service.origen.IOrigenService;

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
public class OrigenExportacionController {
	
	private final IOrigenService origenService;
	
	public OrigenExportacionController(IOrigenService origenService) {
		this.origenService = origenService;
	}
	
	@GetMapping(value = "/origenes.xlsx")
	public ModelAndView exportarOrigen(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Origen> lista = origenService.buscarTodosOrigenes();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/origen");
      model.addAttribute("name", "Reporte Origen");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
