package ob.unibanca.sicf.consultasgenerales.service.binvisa;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IBINVisaMapper;
import ob.unibanca.sicf.consultasgenerales.model.binvisa.BINVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.binvisa.CriterioBusquedaBinVisa;

@Service
public class BINVisaService implements IBINVisaService {

	private final IBINVisaMapper binVisaMapper; 
	
	public BINVisaService(IBINVisaMapper mantenibleMapper) {
		this.binVisaMapper = (IBINVisaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<BINVisa> buscarTodosBINVisa() {
		return this.binVisaMapper.buscarTodos();
	}
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<BINVisa> buscarPorCriterios(CriterioBusquedaBinVisa criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return binVisaMapper.buscarPorCriterios(criterioPaginacion);
	}
	
}
