package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.ReportePrioridad;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReportePrioridad;
import ob.unibanca.sicf.generadorconsultas.service.reporteprioridad.IReportePrioridadService;

@Validated
@RestController
public class ReportePrioridadRestController {

	private @Autowired final IReportePrioridadService reportePrioridadService;

	public ReportePrioridadRestController(IReportePrioridadService reportePrioridadService) {
		this.reportePrioridadService = reportePrioridadService;
	}

	@GetMapping(value = "/reportes/prioridades")
	public List<ReportePrioridad> buscarTodosReportes() {
		return this.reportePrioridadService.buscarTodosReportesPrioridades();

	}
	
	@GetMapping(value = "/reportes/prioridades/buscar")
	public List<ReportePrioridad> buscarTodosReportes(CriterioBusquedaReportePrioridad criterio) {
		return this.reportePrioridadService.buscarPorCriterioReportesPrioridades(criterio);
	}

	@PostMapping(value = "/reportes/prioridades", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ReportePrioridad registrarReportePrioridad(@Validated({ IRegistro.class, Default.class }) @RequestBody ReportePrioridad Reporte) {
		return this.reportePrioridadService.registrarReportePrioridad(Reporte);
	}

	@PutMapping(value = "/reportes/prioridades/{idQueryUsua}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReportePrioridad actualizarReportePrioridad(@IdNumerico(maxRange = 9999) @PathVariable Integer idQueryUsua,
													  @Validated @RequestBody ReportePrioridad reporte) {
		return this.reportePrioridadService.actualizarReportePrioridad(idQueryUsua,reporte);
	}

	@DeleteMapping(value = "/reportes/prioridades/{idQueryUsua}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarReportePrioridad(@IdNumerico(maxRange = 999) @PathVariable int idQueryUsua) {
		this.reportePrioridadService.eliminarReportePrioridad(idQueryUsua);
	}
	
}