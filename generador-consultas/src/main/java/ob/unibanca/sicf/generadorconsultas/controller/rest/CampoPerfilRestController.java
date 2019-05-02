package ob.unibanca.sicf.generadorconsultas.controller.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ob.commons.validation.validation.group.IRegistro;
import ob.unibanca.sicf.generadorconsultas.model.CampoPerfil;
import ob.unibanca.sicf.generadorconsultas.model.Perfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;
import ob.unibanca.sicf.generadorconsultas.service.campoperfil.ICampoPerfilService;



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
	

	@PostMapping(value = "/campo-perfil", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CampoPerfil registrarCampoPerfil(@Validated({IRegistro.class, Default.class}) @RequestBody CampoPerfil campoPerfil) {
		return this.campoPerfilService.registrarCampoPerfil(campoPerfil);
	}
	
}
