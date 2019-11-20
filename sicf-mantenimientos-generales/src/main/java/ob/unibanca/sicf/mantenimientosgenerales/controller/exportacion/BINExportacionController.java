package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN;
import ob.unibanca.sicf.mantenimientosgenerales.service.bin.IBINService;

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
		List<BIN> lista = binService.buscarTodosBINs();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/bin");
      model.addAttribute("name", "Reporte BIN");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
