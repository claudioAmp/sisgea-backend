package edu.taller.sisgea.consultasgenerales.service.incomingIATAS;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATAS.CriterioBusquedaIncomingIATAS;
import edu.taller.sisgea.consultasgenerales.model.incomingIATAS.IncomingIATAS;

public interface IIncomingIATASService {
	
	public Page<IncomingIATAS> buscarPorCriterios (CriterioBusquedaIncomingIATAS criterioPaginacion, int pageNo, int pageSize );
	
}
