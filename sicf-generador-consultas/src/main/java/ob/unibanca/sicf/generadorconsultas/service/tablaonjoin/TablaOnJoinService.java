package ob.unibanca.sicf.generadorconsultas.service.tablaonjoin;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ITablaOnJoinMapper;
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaOnJoin;

@Service
public class TablaOnJoinService extends MantenibleService<TablaOnJoin> implements ITablaOnJoinService {

	private final ITablaOnJoinMapper tablaOnJoinMapper;
	public TablaOnJoinService(@Qualifier("ITablaOnJoinMapper") IMantenibleMapper<TablaOnJoin> mantenibleMapper) {
		super(mantenibleMapper);
		this.tablaOnJoinMapper = (ITablaOnJoinMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablaOnJoin> buscarTodosTablaOnJoin() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablaOnJoin> buscarPorCriteriosTablaOnJoin(CriterioBusquedaTablaOnJoin criterio) {
		return this.tablaOnJoinMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablaOnJoin registrarTablaOnJoin(TablaOnJoin TablaOnJoin) {
		this.registrar(TablaOnJoin);
		return TablaOnJoin;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablaOnJoin actualizarTablaOnJoin(int idTablaOnJoin, TablaOnJoin tablaOnJoin) {
		tablaOnJoin.setIdTablaOnJoin(idTablaOnJoin);
		this.actualizar(tablaOnJoin);
		return tablaOnJoin;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTablaOnJoin(int idTablaOnJoin) {
		TablaOnJoin tablaOnJoin = TablaOnJoin.builder().idTablaOnJoin(idTablaOnJoin).build();
		this.eliminar(tablaOnJoin);
	}

	
}