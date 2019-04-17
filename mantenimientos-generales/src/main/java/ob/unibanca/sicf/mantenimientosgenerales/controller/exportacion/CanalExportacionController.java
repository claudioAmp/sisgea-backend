package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.Canal;
import ob.unibanca.sicf.mantenimientosgenerales.service.canal.ICanalService;

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
public class CanalExportacionController {
	
	private final ICanalService canalService;
	
	public CanalExportacionController(ICanalService canalService) {
		this.canalService = canalService;
	}
	
	@GetMapping(value = "/canales.xlsx")
	public ModelAndView exportarCanal(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Canal> lista = canalService.buscarTodosCanales();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/canal");
      model.addAttribute("name", "Reporte Canal");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
