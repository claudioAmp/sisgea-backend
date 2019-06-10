package ob.unibanca.sicf.generadorconsultas.controller.exportacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.service.reporte.IReporteService;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

@Validated
@Controller
public class ReporteExportacionController {

	private @Autowired final IReporteService reporteService;

	public ReporteExportacionController(IReporteService reporteService) {
		this.reporteService = reporteService;
	}

	@PostMapping(value = "/reportes/exportar-consulta.xls")
	public ModelAndView ejecutarConsulta(@RequestBody List<CampoQuery> campos,
			@RequestParam(value = "consulta") String consulta, ModelMap model) {
		List<Map<String, Object>> resultadoConsulta = reporteService.ejecutarConsulta(consulta);
		model.addAttribute("campos", campos);
		model.addAttribute("consulta", resultadoConsulta);
		return new ModelAndView("xlsReporteView", model);
	}

}