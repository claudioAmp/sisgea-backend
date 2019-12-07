package ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc10;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.IOutgoingVisaTC10Mapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC10TCR0;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutgoingVisaTC10Service implements IOutgoingVisaTC10Service {
	
	private final IOutgoingVisaTC10Mapper outgoingVisaTC10Mapper;
	
	public OutgoingVisaTC10Service(IOutgoingVisaTC10Mapper outgoingVisaTC10Mapper) {
		this.outgoingVisaTC10Mapper = outgoingVisaTC10Mapper;
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<OutgoingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(CriterioBusquedaOutgoingVisaTC10 criterioBusqueda,
	                                                                 int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return outgoingVisaTC10Mapper.buscarPorCriteriosTCR0(criterioBusqueda);
	}
}
