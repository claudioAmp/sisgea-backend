package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;
import ob.unibanca.sicf.mantenimientosgenerales.service.codigotransaccion.ICodigoTransaccionService;

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
public class CodigoTransaccionExportacionController {
	
	private final ICodigoTransaccionService codigoTransaccionService;
	
	public CodigoTransaccionExportacionController(ICodigoTransaccionService codigoTransaccionService) {
		this.codigoTransaccionService = codigoTransaccionService;
	}
	
	@GetMapping(value = "/codigos-transacciones.xlsx")
	public ModelAndView exportarCodigoTransaccion(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CodigoTransaccion> lista = codigoTransaccionService.buscarTodosCodigoTransacciones();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/codigoTransaccion");
      model.addAttribute("name", "Reporte Código Transacción");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
