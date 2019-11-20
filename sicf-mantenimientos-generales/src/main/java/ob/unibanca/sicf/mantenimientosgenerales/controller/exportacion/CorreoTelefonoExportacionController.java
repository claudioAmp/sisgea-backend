package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.util.DatesUtils;
import ob.unibanca.sicf.mantenimientosgenerales.model.CorreoTelefono;
import ob.unibanca.sicf.mantenimientosgenerales.service.correotelefono.ICorreoTelefonoService;

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
public class CorreoTelefonoExportacionController {
	
	private final ICorreoTelefonoService correoTelefonoService;
	
	public CorreoTelefonoExportacionController(ICorreoTelefonoService correoTelefonoService) {
		this.correoTelefonoService = correoTelefonoService;
	}
	@PreAuthorize("hasPermission('MANT_INDCORRTELF', '5')")
	@GetMapping(value = "/correos-telefonos.xlsx")
	public ModelAndView exportarCorreoTelefono(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<CorreoTelefono> lista = correoTelefonoService.buscarTodosCorreosTelefonos();
      params.put("mantenimiento", lista);
      params.put("username", UsuarioUtil.obtenerUsername());
      params.put("fecha", DatesUtils.obtenerFechaYHoraActualDelSistema());
      model.addAttribute("template", "mantenimientosgenerales/correoTelefono");
      model.addAttribute("name", "Reporte CorreoTelefono");
      model.addAttribute("params", params);
      return new ModelAndView("jxlsView", model);
	}

}
