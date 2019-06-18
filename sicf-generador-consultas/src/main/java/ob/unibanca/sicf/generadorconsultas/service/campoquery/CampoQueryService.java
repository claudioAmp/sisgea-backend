package ob.unibanca.sicf.generadorconsultas.service.campoquery;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ICampoQueryMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;

@Service
public class CampoQueryService extends MantenibleService<CampoQuery> implements ICampoQueryService {

	private final ICampoQueryMapper CampoQueryMapper;
	public CampoQueryService(@Qualifier("ICampoQueryMapper") IMantenibleMapper<CampoQuery> mantenibleMapper) {
		super(mantenibleMapper);
		this.CampoQueryMapper = (ICampoQueryMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoQuery> buscarTodosCamposQuery() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoQuery> buscarPorCriteriosCamposQuery(CriterioBusquedaCampoQuery criterio) {
		return this.CampoQueryMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoQuery registrarCampoQuery(CampoQuery CampoQuery) {
		this.registrar(CampoQuery);
		return CampoQuery;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoQuery actualizarCampoQuery(int idCampoQuery, CampoQuery campoQuery) {
		campoQuery.setIdCampoQuery(idCampoQuery);
		this.actualizar(campoQuery);
		return campoQuery;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCampoQuery(int idCampoQuery) {
		CampoQuery campoQuery = CampoQuery.builder().idCampoQuery(idCampoQuery).build();
		this.eliminar(campoQuery);
	}

	
}