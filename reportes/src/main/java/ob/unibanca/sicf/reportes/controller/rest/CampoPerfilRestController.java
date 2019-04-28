package ob.unibanca.sicf.reportes.controller.rest;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ob.unibanca.sicf.reportes.model.CampoPerfil;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaCampoPerfil;
import ob.unibanca.sicf.reportes.service.campoperfil.ICampoPerfilService;

@Validated
@RestController
public class CampoPerfilRestController {
	
	private final ICampoPerfilService campoPerfilService;
	
	public CampoPerfilRestController(ICampoPerfilService campoPerfilService) {
		this.campoPerfilService = campoPerfilService;
	}
	
	@GetMapping(value = "/campo-perfil")
	public List<CampoPerfil> buscarTodosCanales() {
		return this.campoPerfilService.buscarTodosCampoPerfil();
	}
	
	@GetMapping(value = "/campo-perfil/buscar")
	public List<CampoPerfil> buscarTodosCanales(CriterioBusquedaCampoPerfil criterio) {
		return this.campoPerfilService.buscarPorCriteriosCampoPerfil(criterio);
	}
	
	
}
