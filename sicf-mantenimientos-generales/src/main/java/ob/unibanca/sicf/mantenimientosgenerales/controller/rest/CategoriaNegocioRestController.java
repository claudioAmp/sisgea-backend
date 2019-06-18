package ob.unibanca.sicf.mantenimientosgenerales.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ob.unibanca.sicf.mantenimientosgenerales.model.CategoriaNegocio;
import ob.unibanca.sicf.mantenimientosgenerales.service.categorianegocio.ICategoriaNegocioService;

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
