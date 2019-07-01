package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc48;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.consultasgenerales.mapper.IIncomingVisaTC48Mapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;

@Service
public class IncomingVisaTC48Service implements IIncomingVisaTC48Service{
	
	private static final String TRCX_NO_ENCONTRADO = "No existe un TCR%s con identificación de secuencia indicada";
	private final IIncomingVisaTC48Mapper incomingVisaTC48Mapper;
	
	public IncomingVisaTC48Service(IIncomingVisaTC48Mapper incomingVisaTC48Mapper) {
		this.incomingVisaTC48Mapper = incomingVisaTC48Mapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<IncomingVisaTC48> buscaPorCriteriosPaginado(CriterioBusquedaIncomingVisaTC48 criterioBusqueda, int pageNo, int pageSize){
		PageHelper.startPage(pageNo, pageSize);
		return incomingVisaTC48Mapper.buscarPorCriterios(criterioBusqueda);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC48Mapper.buscarPorIdSecuenciaTCR0(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public IncomingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio) {
		return this.incomingVisaTC48Mapper.buscarPorIdSecuenciaTCR1(criterio);
		
	}
}
