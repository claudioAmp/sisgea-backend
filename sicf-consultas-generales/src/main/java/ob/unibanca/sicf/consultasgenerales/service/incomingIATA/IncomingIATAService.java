package ob.unibanca.sicf.consultasgenerales.service.incomingIATA;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingIATAMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import ob.unibanca.sicf.consultasgenerales.model.incomingIATA.IncomingIATA;

@Service
public class IncomingIATAService implements IIncomingIATAService{
	
	private final IIncomingIATAMapper incomingIATAMapper;
	
	public IncomingIATAService(IIncomingIATAMapper mantenibleMapper) {
		this.incomingIATAMapper = (IIncomingIATAMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<IncomingIATA> buscarTodosIncomingIATA(){
		return this.incomingIATAMapper.buscarTodos();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingIATA> buscarPorCriterios(CriterioBusquedaIncomingIATA criterioPaginacion, int pageNo,
			int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return this.incomingIATAMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	
}
