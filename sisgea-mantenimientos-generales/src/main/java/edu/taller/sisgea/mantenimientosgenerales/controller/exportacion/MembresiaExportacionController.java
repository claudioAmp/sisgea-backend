package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.Membresia;
import edu.taller.sisgea.mantenimientosgenerales.service.membresia.IMembresiaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import java.util.List;

@Validated
@Controller
public class MembresiaExportacionController {

	private final IMembresiaService membresiaService;

	public MembresiaExportacionController(IMembresiaService membresiaService) {
		this.membresiaService = membresiaService;
	}

	@GetMapping(value = "/membresias.xlsx")
	public ModelAndView exportarMembresia(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Membresia> lista = membresiaService.buscarTodosMembresias();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
		params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
		model.addAttribute("template", "mantenimientosgenerales/membresia");
		model.addAttribute("name", "Reporte Membresía");
		model.addAttribute("params", params);
		model.addAttribute("username", "Usurio Dummy");
		model.addAttribute("fecha", new Date());
		return new ModelAndView("jxlsView", model);
	}

}
