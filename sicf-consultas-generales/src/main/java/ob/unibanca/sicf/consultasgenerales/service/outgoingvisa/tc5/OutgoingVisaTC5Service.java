package ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc5;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.IOutgoingVisaTC5Mapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC5TCR5;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutgoingVisaTC5Service implements IOutgoingVisaTC5Service {
	
	private final IOutgoingVisaTC5Mapper outgoingVisaTC5Mapper;
	
	public OutgoingVisaTC5Service(IOutgoingVisaTC5Mapper OutgoingVisaTC5Mapper) {
		this.outgoingVisaTC5Mapper = OutgoingVisaTC5Mapper;
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<OutgoingVisaTC5> buscaPorCriteriosTC5PorPagina(CriterioBusquedaOutgoingVisaTC5 criterioBusqueda,
	                                                           int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return outgoingVisaTC5Mapper.buscarPorCriteriosTC5(criterioBusqueda);
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public OutgoingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaOutgoingVisa criterio) {
		return this.outgoingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR0(criterio);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public OutgoingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaOutgoingVisa criterio) {
		return this.outgoingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR1(criterio);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public OutgoingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaOutgoingVisa criterio) {
		return this.outgoingVisaTC5Mapper.buscarPorIdSecuenciaTC5TCR5(criterio);
	}
}
