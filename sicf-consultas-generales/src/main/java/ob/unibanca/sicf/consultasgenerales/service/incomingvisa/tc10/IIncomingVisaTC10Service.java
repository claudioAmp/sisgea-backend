package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc10;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0Det;

public interface IIncomingVisaTC10Service {
	public Page<IncomingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(
			CriterioBusquedaIncomingVisaTC10 criterioBusqueda, int pageNo, int pageSize);
	
	public IncomingVisaTC10TCR0Det buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
}
