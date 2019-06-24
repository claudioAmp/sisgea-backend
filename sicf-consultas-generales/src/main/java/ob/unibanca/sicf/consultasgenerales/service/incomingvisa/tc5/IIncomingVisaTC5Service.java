package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5;


import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC5;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;

public interface IIncomingVisaTC5Service {
	
	Page<IncomingVisaTC5TCR0> buscaPorCriteriosTC5TCR0PorPagina(CriterioBusquedaIncomingVisaTC5 criterioBusqueda, int pageNo, int pageSize);
	
	IncomingVisaTC5TCR0 buscarPorIdSecuenciaTC5TCR0(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR1 buscarPorIdSecuenciaTC5TCR1(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR3 buscarPorIdSecuenciaTC5TCR3(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR4 buscarPorIdSecuenciaTC5TCR4(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR5 buscarPorIdSecuenciaTC5TCR5(CriterioBusquedaIncomingVisa criterio);
}
