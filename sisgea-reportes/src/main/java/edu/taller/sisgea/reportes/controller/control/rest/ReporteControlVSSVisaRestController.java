package edu.taller.sisgea.reportes.controller.control.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.taller.sisgea.reportes.model.control.ReporteControlVSSVisa;
import edu.taller.sisgea.reportes.model.control.criterio.CriterioBusquedaReporteControlVSSVisa;
import edu.taller.sisgea.reportes.service.control.vssvisa.IReporteControlVSSVisaService;

@Validated
@RestController
public class ReporteControlVSSVisaRestController {
	
	private final IReporteControlVSSVisaService reporteControlVSSVisaService;
	
	public ReporteControlVSSVisaRestController(IReporteControlVSSVisaService reporteControlVSSVisaService) {
		this.reporteControlVSSVisaService = reporteControlVSSVisaService;
	}
	
	@PreAuthorize("hasPermission('RPT_CONTROLVSSVISA', '2')")
	@GetMapping(value = "/control/vss/visa")
	public List<ReporteControlVSSVisa> buscarCriterioPorPaginas(CriterioBusquedaReporteControlVSSVisa criterioBusqueda) {
		return this.reporteControlVSSVisaService.buscarPorFechaProceso(criterioBusqueda);
	}
}
