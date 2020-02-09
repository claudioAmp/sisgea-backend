package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.Moneda;
import edu.taller.sisgea.mantenimientosgenerales.service.moneda.IMonedaService;

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
public class MonedaExportacionController {

	private final IMonedaService monedaService;

	public MonedaExportacionController(IMonedaService monedaService) {
		this.monedaService = monedaService;
	}

	@GetMapping(value = "/monedas.xlsx")
	public ModelAndView exportarMoneda(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Moneda> lista = monedaService.buscarTodosMonedas();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
		params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
		model.addAttribute("template", "reportecito");
		model.addAttribute("name", "Reporte ATM");
		model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}

}
