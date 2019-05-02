package ob.unibanca.sicf.tarifarios.controller.exportacion;

import ob.unibanca.sicf.tarifarios.model.TarifarioAdquirente;
import ob.unibanca.sicf.tarifarios.service.tarifarioadquirente.ITarifarioAdquirenteService;

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
public class TarifarioAdquirenteExportacionController {
	
	private final ITarifarioAdquirenteService tarifarioAdquirenteService;
	
	public TarifarioAdquirenteExportacionController(ITarifarioAdquirenteService tarifarioAdquirenteService) {
		this.tarifarioAdquirenteService = tarifarioAdquirenteService;
	}
	
	@GetMapping(value = "/tarifarios-adquirentes.xlsx")
	public ModelAndView exportarTarifarioAdquirente(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<TarifarioAdquirente> lista = tarifarioAdquirenteService.buscarTodosTarifariosAdquirentes();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "tarifarios/tarifarioAdquirente");
      model.addAttribute("name", "Reporte Tarifario Adquirente");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
