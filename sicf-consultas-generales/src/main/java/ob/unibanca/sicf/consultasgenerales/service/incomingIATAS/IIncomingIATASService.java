package ob.unibanca.sicf.consultasgenerales.service.incomingIATAS;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import ob.unibanca.sicf.consultasgenerales.model.incomingIATAS.IncomingIATAS;

public interface IIncomingIATASService {
	
	public Page<IncomingIATAS> buscarPorCriterios (CriterioBusquedaIncomingIATAS criterioPaginacion, int pageNo, int pageSize );
	
}
