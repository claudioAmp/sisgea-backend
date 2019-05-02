package ob.unibanca.sicf.generadorconsultas.service.campoperfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ICampoPerfilMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoPerfil;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoPerfil;



@Service
public class CampoPerfilService extends MantenibleService<CampoPerfil> implements ICampoPerfilService {
	
	private final ICampoPerfilMapper campoPerfilMapper;
	
	public CampoPerfilService(@Qualifier("ICampoPerfilMapper") IMantenibleMapper<CampoPerfil> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoPerfilMapper = (ICampoPerfilMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoPerfil> buscarTodosCampoPerfil() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoPerfil> buscarPorCriteriosCampoPerfil(CriterioBusquedaCampoPerfil criterio) {
		return this.campoPerfilMapper.buscarPorCriterios(criterio);
	}
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoPerfil registrarCampoPerfil(CampoPerfil campoPerfil) {
		this.registrar(campoPerfil);
		return campoPerfil;
	}
}