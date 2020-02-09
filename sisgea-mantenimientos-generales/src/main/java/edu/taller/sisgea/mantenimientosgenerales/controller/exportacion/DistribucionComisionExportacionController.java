package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.taller.sisgea.mantenimientosgenerales.service.distribucioncomision.IDistribucionComisionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.DistribucionComision;

@Validated
@Controller
public class DistribucionComisionExportacionController {

	private final IDistribucionComisionService distribucionComisionService;
	
	public DistribucionComisionExportacionController(IDistribucionComisionService distribucionComisionService) {
		this.distribucionComisionService = distribucionComisionService;
	}
	
	@GetMapping(value = "/distribuciones-comisiones.xlsx")
	public ModelAndView exportarDistribucionComision(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<DistribucionComision> lista = distribucionComisionService.buscarTodosDistComision();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
	    params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
	    model.addAttribute("template", "mantenimientosgenerales/distribucionComision");
	    model.addAttribute("name", "Reporte Distribución Comisión");
	    model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}
}
