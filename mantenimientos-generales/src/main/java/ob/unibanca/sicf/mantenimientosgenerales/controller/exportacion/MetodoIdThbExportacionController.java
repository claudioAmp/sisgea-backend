package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.MetodoIdThb;
import ob.unibanca.sicf.mantenimientosgenerales.service.metodoidthb.IMetodoIdThbService;

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
public class MetodoIdThbExportacionController {
	
	private final IMetodoIdThbService metodoIdThbService;
	
	public MetodoIdThbExportacionController(IMetodoIdThbService metodoIdThbService) {
		this.metodoIdThbService = metodoIdThbService;
	}
	
	@GetMapping(value = "/metodos-id-thb.xlsx")
	public ModelAndView exportarMetodoIdThb(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<MetodoIdThb> lista = metodoIdThbService.buscarTodosMetodoIdThb();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/metodoIdThb");
      model.addAttribute("name", "Reporte Metodo THB");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
