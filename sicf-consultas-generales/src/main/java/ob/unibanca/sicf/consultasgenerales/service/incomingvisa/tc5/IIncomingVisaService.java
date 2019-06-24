package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5;


import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisatTC5TCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC5TCR5;

public interface IIncomingVisaService {
	
	Page<IncomingVisaTC5TCR0> buscaPorCriteriosTCR0PorPagina(CriterioBusquedaIncomingVisaTCR0 criterioBusqueda, int pageNo, int pageSize);
	
	IncomingVisaTC5TCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisatTC5TCR3 buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR4 buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTC5TCR5 buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio);
}
