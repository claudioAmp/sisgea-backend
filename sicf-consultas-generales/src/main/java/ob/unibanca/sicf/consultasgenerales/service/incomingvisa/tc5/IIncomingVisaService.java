package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc5;


import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR1;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR3;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR4;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR5;

public interface IIncomingVisaService {
	
	Page<IncomingVisaTCR0> buscaPorCriteriosTCR0PorPagina(CriterioBusquedaIncomingVisaTCR0 criterioBusqueda, int pageNo, int pageSize);
	
	IncomingVisaTCR0 buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTCR1 buscarPorIdSecuenciaTCR1(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTCR3 buscarPorIdSecuenciaTCR3(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTCR4 buscarPorIdSecuenciaTCR4(CriterioBusquedaIncomingVisa criterio);
	
	IncomingVisaTCR5 buscarPorIdSecuenciaTCR5(CriterioBusquedaIncomingVisa criterio);
}
