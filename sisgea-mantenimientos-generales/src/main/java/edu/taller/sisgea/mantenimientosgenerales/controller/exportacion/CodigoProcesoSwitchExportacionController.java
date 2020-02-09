package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;


import edu.taller.sisgea.mantenimientosgenerales.service.codigoprocesoswitch.ICodigoProcesoSwitchService;
import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.CodigoProcesoSwitch;
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
public class CodigoProcesoSwitchExportacionController {
	
	private final ICodigoProcesoSwitchService codigoProcesoSwitchService;
	
	public CodigoProcesoSwitchExportacionController(ICodigoProcesoSwitchService codigoProcesoSwitchService) {
		this.codigoProcesoSwitchService = codigoProcesoSwitchService;
	}
	
	@GetMapping(value = "/codigos-procesos-switches.xlsx")
	public ModelAndView exportarCodigoProcesoSwitch(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CodigoProcesoSwitch> lista = codigoProcesoSwitchService.buscarTodosCodigoProcesoSwitches();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/codigoProcesoSwitch");
      model.addAttribute("name", "Reporte Código Proceso Switch");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
