package edu.taller.sisgea.tarifarios.controller.exportacion;

import edu.taller.sisgea.tarifarios.service.tipotarifa.ITipoTarifaService;
import edu.taller.sisgea.tarifarios.model.TipoTarifa;

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
public class TipoTarifaExportacionController {
	
	private final ITipoTarifaService tipoTarifaService;
	
	public TipoTarifaExportacionController(ITipoTarifaService tipoTarifaService) {
		this.tipoTarifaService = tipoTarifaService;
	}
	
	@GetMapping(value = "/tipos-tarifas.xlsx")
	public ModelAndView exportarTipoTarifa(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<TipoTarifa> lista = tipoTarifaService.buscarTodosTiposTarifas();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "tarifarios/tipoTarifa");
      model.addAttribute("name", "Reporte TipoTarifa");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
