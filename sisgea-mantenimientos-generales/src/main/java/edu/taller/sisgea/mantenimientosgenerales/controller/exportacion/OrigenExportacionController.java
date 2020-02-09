package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.Origen;
import edu.taller.sisgea.mantenimientosgenerales.service.origen.IOrigenService;

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
public class OrigenExportacionController {

	private final IOrigenService origenService;

	public OrigenExportacionController(IOrigenService origenService) {
		this.origenService = origenService;
	}

	@PreAuthorize("hasPermission('MANT_ORIGEN', '5')")
	@GetMapping(value = "/origenes.xlsx")
	public ModelAndView exportarOrigen(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Origen> lista = origenService.buscarTodosOrigenes();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
		params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
		model.addAttribute("template", "mantenimientosgenerales/origen");
		model.addAttribute("name", "Reporte Origen");
		model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}

}
