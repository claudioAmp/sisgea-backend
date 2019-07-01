package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc48;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC48TCR1;

public interface IIncomingVisaTC48Service {
	
	public Page<IncomingVisaTC48> buscaPorCriteriosPaginado(CriterioBusquedaIncomingVisaTC48 criterioBusqueda, int pageNo, int pageSize);
	
	public IncomingVisaTC48TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	public IncomingVisaTC48TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
}
