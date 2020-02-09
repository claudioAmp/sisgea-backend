package edu.taller.sisgea.mantenimientosgenerales.controller.exportacion;

import edu.taller.sisgea.mantenimientosgenerales.service.instituciontransaccion.IInstitucionTransaccionService;
import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import edu.taller.sisgea.mantenimientosgenerales.model.InstitucionTransaccion;

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
public class InstitucionTransaccionExportacionController {

	private final IInstitucionTransaccionService institucionTransaccionService;

	public InstitucionTransaccionExportacionController(IInstitucionTransaccionService institucionTransaccionService) {
		this.institucionTransaccionService = institucionTransaccionService;
	}

	@PreAuthorize("hasPermission('MANT_INSTRA', '5')")
	@GetMapping(value = "/instituciones-transacciones.xlsx")
	public ModelAndView exportarInstitucionTransaccion(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<InstitucionTransaccion> lista = institucionTransaccionService.buscarTodosInstitucionesTransacciones();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
		params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
		model.addAttribute("template", "mantenimientosgenerales/institucionTransaccion");
		model.addAttribute("name", "Reporte Institución Transacción");
		model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}

}
