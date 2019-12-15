package ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc48;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.IOutgoingVisaTC48Mapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutgoingVisaTC48Service implements IOutgoingVisaTC48Service {
	
	private final IOutgoingVisaTC48Mapper outgoingVisaTC48Mapper;
	
	public OutgoingVisaTC48Service(IOutgoingVisaTC48Mapper outgoingVisaTC48Mapper) {
		this.outgoingVisaTC48Mapper = outgoingVisaTC48Mapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<OutgoingVisaTC48> buscaPorCriteriosPaginado(CriterioBusquedaOutgoingVisaTC48 criterioBusqueda,
	                                                        int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return outgoingVisaTC48Mapper.buscarPorCriterios(criterioBusqueda);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public OutgoingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaOutgoingVisa criterio) {
		return this.outgoingVisaTC48Mapper.buscarPorIdSecuenciaTCR0(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public OutgoingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaOutgoingVisa criterio) {
		return this.outgoingVisaTC48Mapper.buscarPorIdSecuenciaTCR1(criterio);
		
	}
}
