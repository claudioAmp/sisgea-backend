package ob.unibanca.sicf.tarifarios.controller.exportacion;

import ob.unibanca.sicf.tarifarios.model.EscenarioTarifa;
import ob.unibanca.sicf.tarifarios.service.escenariotarifa.IEscenarioTarifaService;

import org.springframework.security.access.prepost.PreAuthorize;
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
public class EscenarioTarifaExportacionController {
	
	private final IEscenarioTarifaService escenarioTarifaService;
	
	public EscenarioTarifaExportacionController(IEscenarioTarifaService escenarioTarifaService) {
		this.escenarioTarifaService = escenarioTarifaService;
	}
	
	@PreAuthorize("hasPermission('MANT_ESCCONT','5')")
	@GetMapping(value = "/escenarios-tarifas.xlsx")
	public ModelAndView exportarEscenarioTarifa(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<EscenarioTarifa> lista = escenarioTarifaService.buscarTodosEscenariosTarifas();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "tarifarios/escenarioTarifa");
      model.addAttribute("name", "Reporte EscenarioTarifa");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
