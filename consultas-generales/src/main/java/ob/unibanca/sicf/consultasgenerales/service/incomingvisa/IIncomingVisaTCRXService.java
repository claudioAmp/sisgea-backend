package ob.unibanca.sicf.consultasgenerales.service.incomingvisa;

import java.util.List;

import ob.unibanca.sicf.consultasgenerales.model.IncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.CriterioBusquedaIncomingVisaTCR0;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.filtro.FiltroDtIncomingVisaTCR0;

public interface IIncomingVisaTCRXService {
	
	public List<IncomingVisaTCR0> buscarTodosIncomingVisaTCR0(
			CriterioPaginacion<CriterioBusquedaIncomingVisaTCR0> criterioPaginacion);
}
