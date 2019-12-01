package ob.unibanca.sicf.consultasgenerales.service.rangobinvisa;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IRangoBINVisaMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinvisa.CriterioBusquedaRangoBinVisa;
import ob.unibanca.sicf.consultasgenerales.model.rangobinvisa.RangoBINVisa;

@Service
public class RangoBINVisaService implements IRangoBINVisaService {

	private final IRangoBINVisaMapper rangoBinVisaMapper; 
	
	public RangoBINVisaService(IRangoBINVisaMapper mantenibleMapper) {
		this.rangoBinVisaMapper = mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<RangoBINVisa> buscarTodosRangoBINVisa() {
		return this.rangoBinVisaMapper.buscarTodos();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<RangoBINVisa> buscarPorCriterios(CriterioBusquedaRangoBinVisa criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println(criterioPaginacion);
		return this.rangoBinVisaMapper.buscarPorCriterios(criterioPaginacion);
	}
	
}
