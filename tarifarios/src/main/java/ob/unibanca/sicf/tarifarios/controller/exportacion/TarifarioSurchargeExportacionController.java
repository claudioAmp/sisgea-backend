package ob.unibanca.sicf.tarifarios.controller.exportacion;

import ob.unibanca.sicf.tarifarios.model.TarifarioSurcharge;
import ob.unibanca.sicf.tarifarios.service.tarifariosurcharge.ITarifarioSurchargeService;

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
public class TarifarioSurchargeExportacionController {
	
	private final ITarifarioSurchargeService tarifarioSurchargeService;
	
	public TarifarioSurchargeExportacionController(ITarifarioSurchargeService tarifarioSurchargeService) {
		this.tarifarioSurchargeService = tarifarioSurchargeService;
	}
	
	@GetMapping(value = "/tarifarios-surcharges.xlsx")
	public ModelAndView exportarTarifarioSurcharge(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<TarifarioSurcharge> lista = tarifarioSurchargeService.buscarTodosTarifariosSurcharges();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "tarifarios/tarifarioSurcharge");
      model.addAttribute("name", "Reporte Tarifario Surcharge");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
