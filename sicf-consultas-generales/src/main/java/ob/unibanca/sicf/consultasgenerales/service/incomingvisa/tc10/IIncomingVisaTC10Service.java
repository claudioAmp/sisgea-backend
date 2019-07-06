package ob.unibanca.sicf.consultasgenerales.service.incomingvisa.tc10;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTC10;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTC10TCR0Det;

public interface IIncomingVisaTC10Service {
	public Page<IncomingVisaTC10TCR0> buscaPorCriteriosTCR0PorPagina(
			CriterioBusquedaIncomingVisaTC10 criterioBusqueda, int pageNo, int pageSize);
	
	public IncomingVisaTC10TCR0Det buscarPorIdSecuenciaTCR0(CriterioBusquedaIncomingVisa criterio);
	
	public Page<IncomingVisaTC10TCR0> buscarPorFiltrosOrdenamiento(
			CriterioBusquedaIncomingVisaTC10 criterioBusqueda,Pagina<CriterioBusquedaIncomingVisaTC10, IncomingVisaTC10TCR0>criterioPaginacion);
}
