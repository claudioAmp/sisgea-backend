package ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc48;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC48TCR1;



public interface IOutgoingVisaTC48Service {
	
	public Page<OutgoingVisaTC48> buscaPorCriteriosPaginado(CriterioBusquedaOutgoingVisaTC48 criterioBusqueda, int pageNo, int pageSize);
	
	public OutgoingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaOutgoingVisa criterio);
	
	public OutgoingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaOutgoingVisa criterio);
}
