package ob.unibanca.sicf.facturacion.controller.exportacion;

import ob.unibanca.sicf.facturacion.model.Portafolio;
import ob.unibanca.sicf.facturacion.service.portafolio.IPortafolioService;

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
public class PortafolioExportacionController {
	
	private final IPortafolioService portafolioService;
	
	public PortafolioExportacionController(IPortafolioService portafolioService) {
		this.portafolioService = portafolioService;
	}
	
	@GetMapping(value = "/portafolios", params ="accion=exportar")
	public ModelAndView exportarPortafolio(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Portafolio> lista = portafolioService.buscarTodosPortafolios();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "facturacion/portafolio");
      model.addAttribute("name", "Reporte Portafolio");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
