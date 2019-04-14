package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.Membresia;
import ob.unibanca.sicf.mantenimientosgenerales.service.membresia.IMembresiaService;

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
public class MembresiaExportacionController {
	
	private final IMembresiaService membresiaService;
	
	public MembresiaExportacionController(IMembresiaService membresiaService) {
		this.membresiaService = membresiaService;
	}
	
	@GetMapping(value = "/membresias", params ="accion=exportar")
	public ModelAndView exportarMembresia(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Membresia> lista = membresiaService.buscarTodosMembresias();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/membresia");
      model.addAttribute("name", "Reporte Membresía");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}