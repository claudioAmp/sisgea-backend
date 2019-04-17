package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.ClaseTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.clasetransaccion.IClaseTransaccionService;

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
public class ClaseTransaccionExportacionController {
	
	private final IClaseTransaccionService claseTransaccionService;
	
	public ClaseTransaccionExportacionController(IClaseTransaccionService claseTransaccionService) {
		this.claseTransaccionService = claseTransaccionService;
	}
	
	@GetMapping(value = "/clases-transacciones.xlsx")
	public ModelAndView exportarClaseTransaccion(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<ClaseTransaccion> lista = claseTransaccionService.buscarTodosClaseTransacciones();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/claseTransaccion");
      model.addAttribute("name", "Reporte Clase Transacción");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
