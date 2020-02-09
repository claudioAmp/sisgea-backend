package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import edu.taller.sisgea.mantenimientosgenerales.service.bin.IBINService;
import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.BIN;

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
public class BINExportacionController {
	
	private final IBINService binService;
	
	public BINExportacionController(IBINService binService) {
		this.binService = binService;
	}
	
	@PreAuthorize("hasPermission('MANT_BIN', '5')")
	@GetMapping(value = "/bins.xlsx")
	public ModelAndView exportarBIN(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<BIN> lista = binService.buscarTodosBIN();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/bin");
      model.addAttribute("name", "Reporte BIN");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
