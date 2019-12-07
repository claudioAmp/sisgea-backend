package ob.unibanca.sicf.consultasgenerales.service.outgoingvisa.tc10;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.criterio.outgoingvisa.CriterioBusquedaOutgoingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import ob.unibanca.sicf.consultasgenerales.model.outgoingvisa.OutgoingVisaTC10TCR0;


public interface IOutgoingVisaTC10Service {
	public Page<OutgoingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(
			CriterioBusquedaOutgoingVisaTC10 criterioBusqueda, int pageNo, int pageSize);
	
	
}
