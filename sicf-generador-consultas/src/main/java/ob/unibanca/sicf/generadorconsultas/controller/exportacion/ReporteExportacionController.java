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
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.service.generarconsulta.IGenerarConsultaService;
import ob.unibanca.sicf.generadorconsultas.service.reporte.IReporteService;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

@Validated
@Controller
public class ReporteExportacionController {

	private @Autowired final IReporteService reporteService;
	private @Autowired final IGenerarConsultaService generarConsultaService;

	public ReporteExportacionController(IReporteService reporteService,IGenerarConsultaService generarConsultaService) {
		this.reporteService = reporteService;
		this.generarConsultaService=generarConsultaService;
	}

	@PostMapping(value = "/reportes/exportar-consulta.xlsx")
	public ModelAndView ejecutarConsulta(@RequestBody Reporte reporte,
	                                     ModelMap model) {
		String consulta="";
		if(reporte.getQueryReporte()!=null) {
			if(reporte.getQueryReporte().isBlank()||reporte.getQueryReporte().isEmpty()) {
				reporte.setQueryReporte(this.generarConsultaService.generarConsulta(reporte));
			}
		} else {
			reporte.setQueryReporte(this.generarConsultaService.generarConsulta(reporte));
		}
		consulta=reporte.getQueryReporte();
		List<Map<String, Object>> resultadoConsulta = reporteService.ejecutarConsulta(consulta);
		model.addAttribute("campos", reporte.getCampos());
		model.addAttribute("consulta", resultadoConsulta);
		model.addAttribute("name", reporte.getNombre());
		return new ModelAndView("xlsReporteView", model);
	}

}
