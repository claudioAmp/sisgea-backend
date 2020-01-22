package ob.unibanca.sicf.consultasgenerales.service.incomingIATAS;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingIATASMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import ob.unibanca.sicf.consultasgenerales.model.incomingIATAS.IncomingIATAS;

@Service
public class IncomingIATASService implements IIncomingIATASService{
	
	private final IIncomingIATASMapper incomingIATASMapper;
	
	public IncomingIATASService(IIncomingIATASMapper incomingIATASMapper) {
		this.incomingIATASMapper = incomingIATASMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingIATAS> buscarPorCriterios(CriterioBusquedaIncomingIATAS criterioPaginacion,int pageNo,int pageSize){
		PageHelper.startPage(pageNo,pageSize);
		return this.incomingIATASMapper.buscarPorCriterios(criterioPaginacion);
	}
	
}
