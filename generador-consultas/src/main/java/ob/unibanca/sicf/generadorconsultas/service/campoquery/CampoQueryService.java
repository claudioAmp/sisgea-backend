package ob.unibanca.sicf.generadorconsultas.service.campoquery;

import java.util.list;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;

@Service
public class CampoQueryService extends MantenibleService<CampoQuery> implements ICampoQueryService {

    private final ICampoQueryMapper campoQueryMapper;

    public CampoQueryService(@Qualifier("IPermisoUsuarioMapper") IMantenibleMapper<CampoQuery> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoQueryMapper = (IcampoQueryMapper) mantenibleMapper;
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoQuery> buscarTodosCampoQuery() {
		return this.buscarTodos();
	}
}