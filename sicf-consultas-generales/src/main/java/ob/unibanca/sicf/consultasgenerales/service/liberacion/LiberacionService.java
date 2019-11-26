package ob.unibanca.sicf.consultasgenerales.service.liberacion;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.ILiberacionMapper;
import ob.unibanca.sicf.consultasgenerales.model.liberacion.Liberacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LiberacionService implements ILiberacionService {
	
	private final ILiberacionMapper liberacionMapper;
	
	public LiberacionService(ILiberacionMapper liberacionMapper) {
		this.liberacionMapper = liberacionMapper;
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Liberacion> buscarPorCriterios(CriterioBusquedaLiberacion criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return liberacionMapper.buscarPorCriterios(criterioPaginacion);
	}
	
}
