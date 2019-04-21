package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.CapacidadTerminalPOS;
import ob.unibanca.sicf.mantenimientosgenerales.service.capacidadterminalpos.ICapacidadTerminalPOSService;

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
public class CapacidadTerminalPOSExportacionController {
	
	private final ICapacidadTerminalPOSService capacidadTerminalPOSService;
	
	public CapacidadTerminalPOSExportacionController(ICapacidadTerminalPOSService capacidadTerminalPOSService) {
		this.capacidadTerminalPOSService = capacidadTerminalPOSService;
	}
	
	@GetMapping(value = "/capacidades-terminales-pos.xlsx")
	public ModelAndView exportarCapacidadTerminalPOS(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CapacidadTerminalPOS> lista = capacidadTerminalPOSService.buscarTodosCapacidadesTerminalesPOS();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/capacidadTerminalPOS");
      model.addAttribute("name", "Reporte CapacidadTerminalPOS");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
