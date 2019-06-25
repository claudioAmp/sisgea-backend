package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;


import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DateUtils;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedAsociada;
import ob.unibanca.sicf.mantenimientosgenerales.service.atmredasociada.IATMRedAsociadaService;

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
public class ATMRedAsociadaExportacionController {
	
	private final IATMRedAsociadaService atmRedAsociadaService;
	
	public ATMRedAsociadaExportacionController(IATMRedAsociadaService atmRedAsociadaService) {
		this.atmRedAsociadaService = atmRedAsociadaService;
	}
	
	@PreAuthorize("hasPermission('MANT_ATREAS', '5')")
	@GetMapping(value = "/atms-redes-asociadas.xlsx")
	public ModelAndView exportarATMRedAsociada(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<ATMRedAsociada> lista = atmRedAsociadaService.buscarTodosATMsRedAsociada();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DateUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/atmRedAsociada");
      model.addAttribute("name", "Reporte ATMRedAsociada");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}