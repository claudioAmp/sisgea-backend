package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.taller.sisgea.mantenimientosgenerales.model.Region;
import edu.taller.sisgea.mantenimientosgenerales.service.region.IRegionService;

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
