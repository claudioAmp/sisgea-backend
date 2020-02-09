package edu.taller.sisgea.consultasgenerales.service.rangobinvisa;


import java.util.List;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.rangobinvisa.CriterioBusquedaRangoBinVisa;
import edu.taller.sisgea.consultasgenerales.model.rangobinvisa.RangoBINVisa;

public interface IRangoBINVisaService {

	List<RangoBINVisa> buscarTodosRangoBINVisa();

	public Page<RangoBINVisa> buscarPorCriterios(CriterioBusquedaRangoBinVisa criterioPaginacion, int pageNo, int pageSize);
	
}
