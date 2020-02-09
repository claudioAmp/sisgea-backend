package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import edu.taller.sisgea.mantenimientosgenerales.model.RespuestaMarcaInt;
import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.service.respuestamarcaint.IRespuestaMarcaIntService;

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
public class RespuestaMarcaIntExportacionController {

	private final IRespuestaMarcaIntService respuestaMarcaIntService;

	public RespuestaMarcaIntExportacionController(IRespuestaMarcaIntService respuestaMarcaIntService) {
		this.respuestaMarcaIntService = respuestaMarcaIntService;
	}

	@GetMapping(value = "/respuestas-marcas-int.xlsx")
	public ModelAndView exportarRespuestaMarcaInt(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<RespuestaMarcaInt> lista = respuestaMarcaIntService.buscarTodosRespuestasMarcasInt();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
		params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
		model.addAttribute("template", "mantenimientosgenerales/respuestaMarcaInt");
		model.addAttribute("name", "Reporte Respuesta Marca Int");
		model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}

}
