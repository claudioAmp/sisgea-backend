package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.mantenimientosgenerales.model.Region;
import ob.unibanca.sicf.mantenimientosgenerales.service.region.IRegionService;

@RestController
public class RegionRestController {
	
	private final IRegionService regionService;
	
	public RegionRestController(IRegionService regionService) {
		this.regionService = regionService;
	}
	//@PreAuthorize("hasPermission('MANT_PAIS', '2')")
	@GetMapping("/regiones")
	public List<Region> buscarTodosRegiones() {
		return this.regionService.buscarTodosRegiones();
	}
	
}
