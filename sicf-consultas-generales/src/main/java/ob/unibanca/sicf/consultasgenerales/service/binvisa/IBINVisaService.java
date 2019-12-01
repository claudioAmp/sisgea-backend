package ob.unibanca.sicf.consultasgenerales.service.binvisa;

import java.util.List;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.binvisa.BINVisa;
import ob.unibanca.sicf.consultasgenerales.model.criterio.binvisa.CriterioBusquedaBinVisa;

public interface IBINVisaService {
	
	List<BINVisa> buscarTodosBINVisa();

	public Page<BINVisa> buscarPorCriterios(CriterioBusquedaBinVisa criterioPaginacion, int pageNo, int pageSize);
	
}
