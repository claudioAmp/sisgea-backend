package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionFondo;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucionfondo.IDistribucionFondoService;

@Validated
@Controller
public class DistribucionFondoExportacionController {

	private final IDistribucionFondoService distribucionFondoService;
	
	public DistribucionFondoExportacionController(IDistribucionFondoService distribucionFondoService) {
		this.distribucionFondoService = distribucionFondoService;
	}
	
	@GetMapping(value = "/distribuciones-fondos.xlsx")
	public ModelAndView exportarDistribucionFondo(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<DistribucionFondo> lista = distribucionFondoService.buscarTodosDistFondo();
		params.put("mantenimiento", lista);
	    model.addAttribute("template", "mantenimientosgenerales/distribucionFondo");
	    model.addAttribute("name", "Reporte Distribución Fondo");
	    model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}
}