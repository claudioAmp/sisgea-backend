package ob.unibanca.sicf.reportes.service.tablasforaneas;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.reportes.model.TablasForaneas;
import ob.unibanca.sicf.reportes.model.criterio.CriterioBusquedaTablasForaneas;

@Service
public class TablasForaneasService extends MantenibleService<TablasForaneas> implements ITablasForaneasService {
	
	public TablasForaneasService(@Qualifier("ITablasForaneasMapper") IMantenibleMapper<TablasForaneas> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablasForaneas> buscarTodos() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TablasForaneas> buscarPorCriterios(CriterioBusquedaTablasForaneas criterio) {
		return this.buscarPorCriterios(criterio);
	}
}
