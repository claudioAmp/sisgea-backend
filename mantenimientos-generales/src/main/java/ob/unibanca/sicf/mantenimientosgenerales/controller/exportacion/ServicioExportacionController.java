package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.Servicio;
import ob.unibanca.sicf.mantenimientosgenerales.service.servicio.IServicioService;

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
public class ServicioExportacionController {
	
	private final IServicioService servicioService;
	
	public ServicioExportacionController(IServicioService servicioService) {
		this.servicioService = servicioService;
	}
	
	@GetMapping(value = "/servicios", params ="accion=exportar")
	public ModelAndView exportarServicio(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Servicio> lista = servicioService.buscarTodosServicios();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/servicio");
      model.addAttribute("name", "Reporte Servicio");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
