package ob.unibanca.sicf.facturacion.controller.exportacion;

import ob.unibanca.sicf.facturacion.model.CodigoFacturacion;
import ob.unibanca.sicf.facturacion.service.codigofacturacion.ICodigoFacturacionService;

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
public class CodigoFacturacionExportacionController {
	
	private final ICodigoFacturacionService codigoFacturacionService;
	
	public CodigoFacturacionExportacionController(ICodigoFacturacionService codigoFacturacionService) {
		this.codigoFacturacionService = codigoFacturacionService;
	}
	
	@GetMapping(value = "/codigos-facturaciones.xlsx")
	public ModelAndView exportarCodigoFacturacion(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CodigoFacturacion> lista = codigoFacturacionService.buscarTodosCodigosFacturaciones();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "facturacion/codigoFacturacion");
      model.addAttribute("name", "Reporte Código Facturación");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
