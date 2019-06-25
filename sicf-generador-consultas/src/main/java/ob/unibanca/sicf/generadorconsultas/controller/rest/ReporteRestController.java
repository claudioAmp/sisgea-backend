package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.generadorconsultas.model.criterio.paginacion.PageParameter;
import ob.unibanca.sicf.generadorconsultas.model.criterio.paginacion.PaginaGeneradorConsulta;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import ob.unibanca.sicf.generadorconsultas.service.reporte.IReporteService;

import java.util.Map;

@Validated
@RestController
public class ReporteRestController {

	private @Autowired final IReporteService reporteService;

	public ReporteRestController(IReporteService reporteService) {
		this.reporteService = reporteService;
	}

	@GetMapping(value = "/reportes")
	public List<Reporte> buscarTodosReportes() {
		List<Reporte> reportes = this.reporteService.buscarTodosReportes();
		return reportes;

	}

	@GetMapping(value = "/reportes/buscar")
	public List<Reporte> buscarTodosReportes(CriterioBusquedaReporte criterio) {
		return this.reporteService.buscarPorCriteriosReporte(criterio);
	}

	@PostMapping(value = "/reportes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reporte registrarReporte(@Validated({ IRegistro.class, Default.class }) @RequestBody Reporte Reporte) {
		this.reporteService.registrarReporteTotal(Reporte);
		return Reporte;
	}

	@PutMapping(value = "/reportes/{idReporte}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reporte actualizarReporte(@IdNumerico(maxRange = 99) @PathVariable int idReporte,
			@Validated @RequestBody Reporte Reporte) {
		return this.reporteService.actualizarReporte(idReporte, Reporte);
	}

	@DeleteMapping(value = "/reportes/{idReporte}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarReporte(@IdNumerico(maxRange = 99) @PathVariable int idReporte) {
		this.reporteService.eliminarReporte(idReporte);
	}

	@GetMapping(value = "/reportes/ejecutar-consulta")
	public PaginaGeneradorConsulta<Map<String, Object>> ejecutarConsulta(@RequestParam String consulta, PageParameter pageParameter) {
		Page<Map<String, Object>> requestList = this.reporteService.ejecutarConsulta(consulta, pageParameter);
		return new PaginaGeneradorConsulta<>(requestList);
	}
}