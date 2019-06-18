package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DateUtils;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.service.institucion.IInstitucionService;

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
public class InstitucionExportacionController {

	private final IInstitucionService institucionService;

	public InstitucionExportacionController(IInstitucionService institucionService) {
		this.institucionService = institucionService;
	}

	@PreAuthorize("hasPermission('MANT_INSTIT', '5')")
	@GetMapping(value = "/instituciones.xlsx")
	public ModelAndView exportarInstitucion(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<Institucion> lista = institucionService.buscarTodosInstituciones();
		params.put("mantenimiento", lista);
		params.put("username", UsuarioUtil.obtenerUsername());
		params.put("fecha", DateUtils.obtenerFechaYHoraActualDelSistema());
		model.addAttribute("template", "mantenimientosgenerales/institucion");
		model.addAttribute("name", "Reporte Institución");
		model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}

}
