package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;


import edu.taller.sisgea.mantenimientosgenerales.model.CodigoRespuestaSwitch;
import edu.taller.sisgea.mantenimientosgenerales.service.codigorespuestaswitch.ICodigoRespuestaSwitchService;
import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
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
public class CodigoRespuestaSwitchExportacionController {
	
	private final ICodigoRespuestaSwitchService codigoRespuestaSwitchService;
	
	public CodigoRespuestaSwitchExportacionController(ICodigoRespuestaSwitchService codigoRespuestaSwitchService) {
		this.codigoRespuestaSwitchService = codigoRespuestaSwitchService;
	}
	
	@GetMapping(value = "/codigos-respuestas-switches.xlsx")
	public ModelAndView exportarCodigoRespuestaSwitch(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CodigoRespuestaSwitch> lista = codigoRespuestaSwitchService.buscarTodosCodigoRespuetaSwitches();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/codigoRespuestaSwitch");
      model.addAttribute("name", "Reporte Código Respuesta Switch");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
