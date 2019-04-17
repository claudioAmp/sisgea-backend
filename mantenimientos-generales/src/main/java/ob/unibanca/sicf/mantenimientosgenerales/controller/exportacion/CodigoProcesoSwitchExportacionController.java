package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;


import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;
import ob.unibanca.sicf.mantenimientosgenerales.service.codigoprocesoswitch.ICodigoProcesoSwitchService;
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
public class CodigoProcesoSwitchExportacionController {
	
	private final ICodigoProcesoSwitchService codigoProcesoSwitchService;
	
	public CodigoProcesoSwitchExportacionController(ICodigoProcesoSwitchService codigoProcesoSwitchService) {
		this.codigoProcesoSwitchService = codigoProcesoSwitchService;
	}
	
	@GetMapping(value = "/codigos-procesos-switches.xlsx")
	public ModelAndView exportarCodigoProcesoSwitch(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CodigoProcesoSwitch> lista = codigoProcesoSwitchService.buscarTodosCodigoProcesoSwitches();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/codigoProcesowitch");
      model.addAttribute("name", "Reporte Código Proceso Switch");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
