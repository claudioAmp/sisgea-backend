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

import ob.commons.truncadorpan.decisor.IVisualizacionPANService;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.UltimoSecuencia;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaReporte;
import ob.unibanca.sicf.generadorconsultas.service.generarconsulta.IGenerarConsultaService;
import ob.unibanca.sicf.generadorconsultas.service.reporte.IReporteService;
import ob.unibanca.sicf.generadorconsultas.service.ultimosecuencia.IUltimoSecuenciaService;

import java.util.Map;

@Validated
@RestController
public class ReporteRestController {

	private @Autowired final IReporteService reporteService;
	private @Autowired final IGenerarConsultaService generarConsultaService;
	private @Autowired final IVisualizacionPANService visualizacionPANService;

	public ReporteRestController(IReporteService reporteService,IGenerarConsultaService generarConsultaService,IVisualizacionPANService visualizacionPANService) {
		this.reporteService = reporteService;
		this.generarConsultaService=generarConsultaService;
		this.visualizacionPANService=visualizacionPANService;
	}

	@GetMapping(value = "/reportes")
	public List<Reporte> buscarTodosReportes() {
		List<Reporte> reportes = this.reporteService.buscarTodosReportes();
		return reportes;

	}
	@GetMapping(value = "/reportes/{idReporte}")
	public List<Reporte> buscarReporte(@IdNumerico(maxRange = 999) @PathVariable int idReporte) {
		return this.reporteService.buscarReporte(idReporte);

	}

	@GetMapping(value = "/reportes/buscar")
	public List<Reporte> buscarTodosReportes(CriterioBusquedaReporte criterio) {
		return this.reporteService.buscarPorCriteriosReporte(criterio);
	}

	@PostMapping(value = "/reportes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reporte registrarReporte(@Validated({ IRegistro.class, Default.class }) @RequestBody Reporte Reporte) {
		return this.reporteService.registrarReporteTotal(0,Reporte);
	}

	@PutMapping(value = "/reportes/{idReporte}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reporte actualizarReporte(@IdNumerico(maxRange = 999) @PathVariable int idReporte,
			@Validated @RequestBody Reporte Reporte) {
		return this.reporteService.actualizarReporte(idReporte, Reporte);
	}

	@DeleteMapping(value = "/reportes/{idReporte}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarReporte(@IdNumerico(maxRange = 999) @PathVariable int idReporte) {
		this.reporteService.eliminarReporte(idReporte);
	}

	@PostMapping(value = "/reportes/ejecutar-consulta/{pageNum}/{pageSize}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PaginaGeneradorConsulta<Map<String, Object>> ejecutarConsulta(@PathVariable int pageNum, @PathVariable int pageSize, @RequestBody Reporte reporte) {
		 PageParameter pageParameter= new  PageParameter();
		 pageParameter.setPageNum(pageNum);
		 pageParameter.setPageSize(pageSize);
		 this.reporteService.detectarPAN(reporte);
		reporte.setVisualiza(this.visualizacionPANService.puedeVisualizarPAN());
		reporte.setQueryReporte(this.generarConsultaService.generarConsulta(reporte));
		System.out.println(reporte.getQueryReporte());
		Page<Map<String, Object>> requestList = this.reporteService.ejecutarConsulta(reporte.getQueryReporte(), pageParameter);
		return new PaginaGeneradorConsulta<>(requestList);
	}
}