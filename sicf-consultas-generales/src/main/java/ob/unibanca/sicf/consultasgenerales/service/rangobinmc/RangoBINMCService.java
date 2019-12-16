package ob.unibanca.sicf.consultasgenerales.service.rangobinmc;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.unibanca.sicf.consultasgenerales.mapper.IRangoBINMCMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinmc.CriterioBusquedaRangoBINMC;
import ob.unibanca.sicf.consultasgenerales.model.rangobinmc.RangoBINMC;

@Service
public class RangoBINMCService implements IRangoBINMCService{
	
private final IRangoBINMCMapper rangoBINMCMapper; 
	
	public RangoBINMCService(IRangoBINMCMapper mantenibleMapper) {
		this.rangoBINMCMapper = mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<RangoBINMC> buscarTodosRangoBINMC() {
		return this.rangoBINMCMapper.buscarTodos();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<RangoBINMC> buscarPorCriterios(CriterioBusquedaRangoBINMC criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		System.out.println(criterioPaginacion);
		return this.rangoBINMCMapper.buscarPorCriterios(criterioPaginacion);
	}
	
}
