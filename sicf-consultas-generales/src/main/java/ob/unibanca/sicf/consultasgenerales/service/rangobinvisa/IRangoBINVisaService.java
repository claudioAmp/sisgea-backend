package ob.unibanca.sicf.consultasgenerales.service.rangobinvisa;


import java.util.List;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinvisa.CriterioBusquedaRangoBinVisa;
import ob.unibanca.sicf.consultasgenerales.model.rangobinvisa.RangoBINVisa;

public interface IRangoBINVisaService {

	List<RangoBINVisa> buscarTodosRangoBINVisa();

	public Page<RangoBINVisa> buscarPorCriterios(CriterioBusquedaRangoBinVisa criterioPaginacion, int pageNo, int pageSize);
	
}
