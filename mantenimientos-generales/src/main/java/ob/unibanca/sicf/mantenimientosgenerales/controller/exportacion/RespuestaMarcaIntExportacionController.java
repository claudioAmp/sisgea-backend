package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.unibanca.sicf.mantenimientosgenerales.model.RespuestaMarcaInt;
import ob.unibanca.sicf.mantenimientosgenerales.service.respuestamarcaint.IRespuestaMarcaIntService;

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
public class RespuestaMarcaIntExportacionController {
	
	private final IRespuestaMarcaIntService respuestaMarcaIntService;
	
	public RespuestaMarcaIntExportacionController(IRespuestaMarcaIntService respuestaMarcaIntService) {
		this.respuestaMarcaIntService = respuestaMarcaIntService;
	}
	
	@GetMapping(value = "/respuestas-marcas-int.xlsx")
	public ModelAndView exportarRespuestaMarcaInt(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<RespuestaMarcaInt> lista = respuestaMarcaIntService.buscarTodosRespuestasMarcasInt();
      params.put("mantenimiento", lista);
      model.addAttribute("template", "mantenimientosgenerales/respuestaMarcaInt");
      model.addAttribute("name", "Reporte Respuesta Marca Int");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
