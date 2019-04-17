package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.InstitucionTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.instituciontransaccion.IInstitucionTransaccionService;

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
public class InstitucionTransaccionExportacionController {
	
	private final IInstitucionTransaccionService institucionTransaccionService;
	
	public InstitucionTransaccionExportacionController(IInstitucionTransaccionService institucionTransaccionService) {
		this.institucionTransaccionService = institucionTransaccionService;
	}
	
	@GetMapping(value = "/instituciones-transacciones.xlsx")
	public ModelAndView exportarInstitucionTransaccion(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<InstitucionTransaccion> lista = institucionTransaccionService.buscarTodosInstitucionesTransacciones();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/institucionTransaccion");
      model.addAttribute("name", "Reporte Institución Transacción");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
