package ob.unibanca.sicf.consultasgenerales.service.pmp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.unibanca.sicf.consultasgenerales.mapper.IPMPMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.pmp.CriterioBusquedaPMP;
import ob.unibanca.sicf.consultasgenerales.model.pmp.PMP;

@Service
public class PMPService implements IPMPService{

	private final IPMPMapper pmpMapper; 
	
	public PMPService(IPMPMapper mantenibleMapper) {
		this.pmpMapper = (IPMPMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PMP> buscarTodosPMP() {
		return this.pmpMapper.buscarTodos();
	}
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<PMP> buscarPorCriterios(CriterioBusquedaPMP criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return this.pmpMapper.buscarPorCriterios(criterioPaginacion);
	}
	
}
