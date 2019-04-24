package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionComision;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucioncomision.IDistribucionComisionService;

@Validated
@Controller
public class DistribucionComisionExportacionController {

	private final IDistribucionComisionService distribucionComisionService;
	
	public DistribucionComisionExportacionController(IDistribucionComisionService distribucionComisionService) {
		this.distribucionComisionService = distribucionComisionService;
	}
	
	@GetMapping(value = "/distribuciones-comisiones.xlsx")
	public ModelAndView exportarDistribucionComision(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<DistribucionComision> lista = distribucionComisionService.buscarTodosDistComision();
		params.put("mantenimiento", lista);
	    model.addAttribute("template", "mantenimientosgenerales/distribucionComision");
	    model.addAttribute("name", "Reporte Distribución Comisión");
	    model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}
}
