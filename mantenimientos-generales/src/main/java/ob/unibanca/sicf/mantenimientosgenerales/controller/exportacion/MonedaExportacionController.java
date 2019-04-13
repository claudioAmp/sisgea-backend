package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.Moneda;
import ob.unibanca.sicf.mantenimientosgenerales.service.moneda.IMonedaService;

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
public class MonedaExportacionController {
	
	private final IMonedaService monedaService;
	
	public MonedaExportacionController(IMonedaService monedaService) {
		this.monedaService = monedaService;
	}
	
	@GetMapping(value = "/monedas", params ="accion=exportar")
	public ModelAndView exportarMoneda(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Moneda> lista = monedaService.buscarTodosMonedas();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "reportecito");
      model.addAttribute("name", "Reporte ATM");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
