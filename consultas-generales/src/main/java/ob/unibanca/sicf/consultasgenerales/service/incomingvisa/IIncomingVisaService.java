package ob.unibanca.sicf.consultasgenerales.service.incomingvisa;


import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingvisa.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.incomingvisa.IncomingVisaTCR0;

public interface IIncomingVisaService {
	
	public Page<IncomingVisaTCR0> buscaPorCriterios(
			CriterioBusquedaIncomingVisaTCR0 criterioPaginacion);
}
