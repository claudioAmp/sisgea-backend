package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisaeventos.IDistribucionVisaEventosService;

import java.util.List;

@Validated
@RestController
public class DistribucionVisaEventosRestController {
	
	private final IDistribucionVisaEventosService binService;
	
	public DistribucionVisaEventosRestController(IDistribucionVisaEventosService binService) {
		this.binService = binService;
	}
	
	@PreAuthorize("hasPermission('MANT_DIST_EVENTO_VISA', '2')")
	@GetMapping("/distribucionVisaEventos")
	public List<DistribucionVisaEventos> buscarTodosDistribucionVisaEventos() {
		return this.binService.buscarRegistrosDistribucionEventosVisa();
	}
	
	@PreAuthorize("hasPermission('MANT_DIST_EVENTO_VISA', '3')")
	@PutMapping("/distribucionVisaEventos")
	public List<DistribucionVisaEventos> actualizarDistribucionVisaEventos(DistribucionVisaEventos distribucionVisaEventos) {
		return this.binService.buscarRegistrosDistribucionEventosVisa();
	}
	
}
