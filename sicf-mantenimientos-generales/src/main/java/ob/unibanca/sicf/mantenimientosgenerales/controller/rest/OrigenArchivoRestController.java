package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import ob.unibanca.sicf.mantenimientosgenerales.model.OrigenArchivo;
import ob.unibanca.sicf.mantenimientosgenerales.service.origenarchivo.IOrigenArchivoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class OrigenArchivoRestController {
	
	private final IOrigenArchivoService origenArchivoService;
	
	public OrigenArchivoRestController(IOrigenArchivoService origenArchivoService) {
		this.origenArchivoService = origenArchivoService;
	}
	
	@PreAuthorize("hasPermission('MANT_ORIARC', '2')")
	@GetMapping("/origenes-archivos")
	public List<OrigenArchivo> buscarTodosOrigenArchivos() {
		return this.origenArchivoService.buscarTodosOrigenArchivo();
	}
	
	@PreAuthorize("hasPermission('MANT_ORIARC', '2')")
	@GetMapping("/origenes-archivos/buscar")
	public List<OrigenArchivo> buscarOrigenArchivoPorConciliacion(boolean concilia) {
		return this.origenArchivoService.buscarOrigenArchivoPorConciliacion(concilia);
	}
	
}
