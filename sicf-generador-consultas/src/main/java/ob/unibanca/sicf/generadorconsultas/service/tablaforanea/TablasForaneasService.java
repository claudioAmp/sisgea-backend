package ob.unibanca.sicf.generadorconsultas.service.tablaforanea;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.generadorconsultas.mapper.ITablasForaneasMapper;
import ob.unibanca.sicf.generadorconsultas.model.TablasForaneas;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablasForaneas;



@Service
public class TablasForaneasService extends MantenibleService<TablasForaneas> implements ITablasForaneasService {
	
	private final ITablasForaneasMapper tablasForaneasMapper;
	
	public TablasForaneasService(@Qualifier("ITablasForaneasMapper") IMantenibleMapper<TablasForaneas> mantenibleMapper) {
		super(mantenibleMapper);
		this.tablasForaneasMapper = (ITablasForaneasMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablasForaneas> buscarTodosTablasForaneas() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablasForaneas> buscarPorCriteriosTablasForaneas(CriterioBusquedaTablasForaneas criterio) {
		return this.tablasForaneasMapper.buscarPorCriterios(criterio);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablasForaneas registrarTablasForaneas(TablasForaneas tablaForanea) {
		this.registrar(tablaForanea);
		return tablaForanea;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TablasForaneas actualizarTablasForaneas(int idRelacionTablaFk, TablasForaneas tablaForanea) {
		tablaForanea.setIdRelacionTablaFk(idRelacionTablaFk);
		this.actualizar(tablaForanea);
		return tablaForanea;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTablasForaneas(int idRelacionTablaFk) {
		TablasForaneas tablaForanea = TablasForaneas.builder().idRelacionTablaFk(idRelacionTablaFk).build();
		this.eliminar(tablaForanea);
	}
}
