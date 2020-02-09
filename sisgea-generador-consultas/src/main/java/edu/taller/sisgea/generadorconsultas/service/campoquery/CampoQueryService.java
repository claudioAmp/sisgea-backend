package edu.taller.sisgea.generadorconsultas.service.campoquery;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.mapper.ICampoQueryMapper;
import edu.taller.sisgea.generadorconsultas.model.CampoQuery;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaCampoQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;

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
		if(criterio.getPermited()==1) {
			criterio.setUsuario(UsuarioUtil.obtenerUsername().toUpperCase());
		}
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