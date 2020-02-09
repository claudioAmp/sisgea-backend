package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.DistribucionFondo;
import edu.taller.sisgea.mantenimientosgenerales.service.distribucionfondo.IDistribucionFondoService;

@Validated
@Controller
public class DistribucionFondoExportacionController {

	private final IDistribucionFondoService distribucionFondoService;
	
	public DistribucionFondoExportacionController(IDistribucionFondoService distribucionFondoService) {
		this.distribucionFondoService = distribucionFondoService;
	}
	@PreAuthorize("hasPermission('MANT_REGCOMPFOND', '5')")
	@GetMapping(value = "/distribuciones-fondos.xlsx")
	public ModelAndView exportarDistribucionFondo(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<DistribucionFondo> lista = distribucionFondoService.buscarTodosDistFondo();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
	    params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
	    model.addAttribute("template", "mantenimientosgenerales/distribucionFondo");
	    model.addAttribute("name", "Reporte Distribución Fondo");
	    model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}
}
