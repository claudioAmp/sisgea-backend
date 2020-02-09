package edu.taller.sisgea.mantenimientosgenerales.controller.rest;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.CategoriaNegocio;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.taller.sisgea.mantenimientosgenerales.service.categorianegocio.ICategoriaNegocioService;

@Validated
@RestController
public class CategoriaNegocioRestController {
	
	private final ICategoriaNegocioService categoriaNegocioService;
	
	public CategoriaNegocioRestController(ICategoriaNegocioService categoriaNegocioService) {
		this.categoriaNegocioService = categoriaNegocioService;
	}
	
	@GetMapping(value = "/categorias-negocios")
	public List<CategoriaNegocio> buscarTodosCategoriasNegocios() {
		return this.categoriaNegocioService.buscarTodosCategoriasNegocios();
	}
}
