package ob.unibanca.sicf.reportes.service.campoperfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.reportes.mapper.ICampoPerfilMapper;
import ob.unibanca.sicf.reportes.model.CampoPerfil;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaCampoPerfil;


@Service
public class CampoPerfilService extends MantenibleService<CampoPerfil> implements ICampoPerfilService {
	
	private final ICampoPerfilMapper CampoPerfilMapper;
	
	public CampoPerfilService(@Qualifier("ICampoPerfilMapper") IMantenibleMapper<CampoPerfil> mantenibleMapper) {
		super(mantenibleMapper);
		this.CampoPerfilMapper = (ICampoPerfilMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoPerfil> buscarTodosCampoPerfil() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoPerfil> buscarPorCriteriosCampoPerfil(CriterioBusquedaCampoPerfil criterio) {
		return this.CampoPerfilMapper.buscarPorCriterios(criterio);
	}
}
