package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

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

import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;
import ob.unibanca.sicf.generadorconsultas.service.reporte.IReporteService;
import ob.unibanca.sicf.generadorconsultas.service.tablaquery.*;




@Validated
@RestController
public class ReporteRestController {
	
	private final IReporteService ReporteService;
	private final ITablaQueryService tablaQueryService;
	
	public ReporteRestController(IReporteService ReporteService,ITablaQueryService TablaQueryService ) {
		this.ReporteService = ReporteService;
		this.tablaQueryService = TablaQueryService;
	}
	
	@GetMapping(value = "/reportes")
	public List<Reporte> buscarTodosReportes() {
		List<Reporte> reportes = this.ReporteService.buscarTodosReportes();
		CriterioBusquedaTablaQuery criterio = new CriterioBusquedaTablaQuery() ;
		for (Reporte r : reportes) {
			criterio.setIdReporte(r.getIdReporte());
			r.setTablas(this.tablaQueryService.buscarPorCriteriosTablaQuery(criterio));
		}
		return reportes;
		
	}
	@GetMapping(value = "/reportes/buscar")
	public List<Reporte> buscarTodosReportes(CriterioBusquedaReporte criterio) {
		return this.ReporteService.buscarPorCriteriosReporte(criterio);
	}
	@PostMapping(value = "/reportes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reporte registrarReporte(@Validated({IRegistro.class, Default.class}) @RequestBody Reporte Reporte) {
		return this.ReporteService.registrarReporte(Reporte);
	}
	
	@PutMapping(value = "/reportes/{idReporte}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reporte actualizarReporte(@IdNumerico(maxRange = 99) @PathVariable int idReporte,
	                             @Validated @RequestBody Reporte Reporte) {
		return this.ReporteService.actualizarReporte(idReporte, Reporte);
	}
	
	@DeleteMapping(value = "/reportes/{idReporte}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarReporte(@IdNumerico(maxRange = 99) @PathVariable int idReporte) {
		this.ReporteService.eliminarReporte(idReporte);
	}
}