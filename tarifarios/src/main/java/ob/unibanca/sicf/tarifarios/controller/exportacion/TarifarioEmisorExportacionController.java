package ob.unibanca.sicf.tarifarios.controller.exportacion;

import ob.unibanca.sicf.tarifarios.model.TarifarioEmisor;
import ob.unibanca.sicf.tarifarios.service.tarifarioemisor.ITarifarioEmisorService;

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
public class TarifarioEmisorExportacionController {
	
	private final ITarifarioEmisorService tarifarioEmisorService;
	
	public TarifarioEmisorExportacionController(ITarifarioEmisorService tarifarioEmisorService) {
		this.tarifarioEmisorService = tarifarioEmisorService;
	}
	
	@GetMapping(value = "/tarifarios-emisores.xlsx")
	public ModelAndView exportarTarifarioEmisor(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<TarifarioEmisor> lista = tarifarioEmisorService.buscarTodosTarifariosEmisores();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "tarifarios/tarifarioEmisor");
      model.addAttribute("name", "Reporte Tarifario Ruteo");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
