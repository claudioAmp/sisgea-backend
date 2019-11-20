package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedUnicard;
import ob.unibanca.sicf.mantenimientosgenerales.service.atmredunicard.IATMRedUnicardService;

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
public class ATMRedUnicardExportacionController {
	
	private final IATMRedUnicardService atmRedUnicardService;
	
	public ATMRedUnicardExportacionController(IATMRedUnicardService atmRedUnicardService) {
		this.atmRedUnicardService = atmRedUnicardService;
	}
	
	@PreAuthorize("hasPermission('MANT_ATREUN', '5')")
	@GetMapping(value = "/atms-redes-unicard.xlsx")
	public ModelAndView exportarATMRedUnicard(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<ATMRedUnicard> lista = atmRedUnicardService.buscarTodosATMsRedUnicard();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/atmRedUnicard");
      model.addAttribute("name", "Reporte ATMRedUnicard");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
