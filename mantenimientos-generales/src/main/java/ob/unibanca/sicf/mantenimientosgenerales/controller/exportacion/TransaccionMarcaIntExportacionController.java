package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.TransaccionMarcaInt;
import ob.unibanca.sicf.mantenimientosgenerales.service.transaccionmarcaint.ITransaccionMarcaIntService;

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
public class TransaccionMarcaIntExportacionController {
	
	private final ITransaccionMarcaIntService transaccionMarcaIntService;
	
	public TransaccionMarcaIntExportacionController(ITransaccionMarcaIntService transaccionMarcaIntService) {
		this.transaccionMarcaIntService = transaccionMarcaIntService;
	}
	
	@GetMapping(value = "/transacciones-marcas-internacionales", params ="accion=exportar")
	public ModelAndView exportarTransaccionMarcaInt(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<TransaccionMarcaInt> lista = transaccionMarcaIntService.buscarTodasTransaccionesMarcaInt();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "reportecito");
      model.addAttribute("name", "Reporte ATM");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
