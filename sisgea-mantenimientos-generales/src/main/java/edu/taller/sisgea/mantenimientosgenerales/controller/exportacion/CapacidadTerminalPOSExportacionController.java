package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import edu.taller.sisgea.mantenimientosgenerales.model.CapacidadTerminalPOS;
import edu.taller.sisgea.mantenimientosgenerales.service.capacidadterminalpos.ICapacidadTerminalPOSService;
import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;

import org.springframework.security.access.prepost.PreAuthorize;
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
public class CapacidadTerminalPOSExportacionController {
	
	private final ICapacidadTerminalPOSService capacidadTerminalPOSService;
	
	public CapacidadTerminalPOSExportacionController(ICapacidadTerminalPOSService capacidadTerminalPOSService) {
		this.capacidadTerminalPOSService = capacidadTerminalPOSService;
	}
	@PreAuthorize("hasPermission('MANT_CAPTERPOS', '5')")
	@GetMapping(value = "/capacidades-terminales-pos.xlsx")
	public ModelAndView exportarCapacidadTerminalPOS(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CapacidadTerminalPOS> lista = capacidadTerminalPOSService.buscarTodosCapacidadesTerminalesPOS();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/capacidadTerminalPOS");
      model.addAttribute("name", "Reporte Capacidad Terminal POS");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
