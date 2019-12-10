package ob.unibanca.sicf.consultasgenerales.service.incomingIATA;

import java.util.List;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import ob.unibanca.sicf.consultasgenerales.model.incomingIATA.IncomingIATA;

public interface IIncomingIATAService {
	
	List<IncomingIATA> buscarTodosIncomingIATA ();
	
	public Page<IncomingIATA> buscarPorCriterios(CriterioBusquedaIncomingIATA criterioPaginacion, int pageNo, int pageSize );
	
}
