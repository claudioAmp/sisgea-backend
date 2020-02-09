package edu.taller.sisgea.consultasgenerales.service.incomingIATA;

import java.util.List;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import edu.taller.sisgea.consultasgenerales.model.incomingIATA.IncomingIATA;
import edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATA.CriterioBusquedaIncomingIATA;
import edu.taller.sisgea.consultasgenerales.model.incomingIATA.IncomingIATA;

public interface IIncomingIATAService {
	
	List<IncomingIATA> buscarTodosIncomingIATA ();
	
	public Page<IncomingIATA> buscarPorCriterios(CriterioBusquedaIncomingIATA criterioPaginacion, int pageNo, int pageSize );
	
}
