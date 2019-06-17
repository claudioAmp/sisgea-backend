package ob.unibanca.sicf.mantenimientosgenerales.controller.exportacion;

import ob.commons.util.DateUtils;
import ob.unibanca.sicf.mantenimientosgenerales.model.ModoEntradaPOS;
import ob.unibanca.sicf.mantenimientosgenerales.service.modoentradapos.IModoEntradaPOSService;

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
public class ModoEntradaPOSExportacionController {

	private final IModoEntradaPOSService modoEntradaPOSService;

	public ModoEntradaPOSExportacionController(IModoEntradaPOSService modoEntradaPOSService) {
		this.modoEntradaPOSService = modoEntradaPOSService;
	}

	@PreAuthorize("hasPermission('MANT_MODENTPOS', '5')")
	@GetMapping(value = "/modos-entradas-pos.xlsx")
	public ModelAndView exportarModoEntradaPOS(ModelMap model) {
		Map<String, Object> params = new HashMap<>();
		List<ModoEntradaPOS> lista = modoEntradaPOSService.buscarTodosModosEntradasPOS();
		params.put("mantenimiento", lista);
		params.put("username", "Usuario Dummy");
		params.put("fecha", DateUtils.obtenerFechaYHoraActualDelSistema());
		model.addAttribute("template", "mantenimientosgenerales/modoEntradaPOS");
		model.addAttribute("name", "Reporte ModoEntradaPOS");
		model.addAttribute("params", params);
		return new ModelAndView("jxlsView", model);
	}

}
