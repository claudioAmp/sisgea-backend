package ob.unibanca.sicf.generadorconsultas.service.tablaquery;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ITablaQueryMapper;
import ob.unibanca.sicf.generadorconsultas.mapper.ITablasForaneasMapper;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaQuery;


@Service
public class TablaQueryService extends MantenibleService<TablaQuery> implements ITablaQueryService {
	
	private final ITablaQueryMapper TablaQueryMapper;
	public TablaQueryService(@Qualifier("ITablaQueryMapper") IMantenibleMapper<TablaQuery> mantenibleMapper) {
		super(mantenibleMapper);
		this.TablaQueryMapper = (ITablaQueryMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablaQuery> buscarTodosTablasQuery() {
		return this.buscarTodos();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablaQuery> buscarPorCriteriosTablaQuery(CriterioBusquedaTablaQuery criterio) {
		return this.TablaQueryMapper.buscarPorCriterios(criterio);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablaQuery registrarTablaQuery(TablaQuery TablaQuery) {
		this.registrar(TablaQuery);
		return TablaQuery;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablaQuery actualizarTablaQuery(int idTablaQuery, TablaQuery tablaQuery) {
		tablaQuery.setIdTabla(idTablaQuery);
		this.actualizar(tablaQuery);
		return tablaQuery;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTablaQuery(int idTablaQuery) {
		TablaQuery tablaQuery = TablaQuery.builder().idTabla(idTablaQuery).build();
		this.eliminar(tablaQuery);
	}
}

