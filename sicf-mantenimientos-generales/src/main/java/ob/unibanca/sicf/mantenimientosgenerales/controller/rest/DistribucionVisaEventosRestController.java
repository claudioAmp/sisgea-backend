package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisaeventos.IDistribucionVisaEventosService;

import java.util.List;

@Validated
@RestController
public class DistribucionVisaEventosRestController {
	
	private final IDistribucionVisaEventosService distribucionService;
	
	public DistribucionVisaEventosRestController(IDistribucionVisaEventosService distribucionService) {
		this.distribucionService = distribucionService;
	}
	
	@PreAuthorize("hasPermission('MANT_DIST_EVENTO_VISA', '2')")
	@GetMapping("/distribucionVisaEventos")
	public List<DistribucionVisaEventos> buscarTodosDistribucionVisaEventos() {
		return this.distribucionService.buscarRegistrosDistribucionEventosVisa();
	}
	
	@PreAuthorize("hasPermission('MANT_DIST_EVENTO_VISA', '3')")
	@PutMapping("/distribucionVisaEventos/{secuenciaAgrupada}")
	public DistribucionVisaEventos actualizarDistribucionVisaEventos(
		@PathVariable String secuenciaAgrupada,
		@Validated @RequestBody DistribucionVisaEventos distribucionVisaEventos) {
		return this.distribucionService.actualizarDistribucionVisaEventos(secuenciaAgrupada, distribucionVisaEventos);
	}
	
}
