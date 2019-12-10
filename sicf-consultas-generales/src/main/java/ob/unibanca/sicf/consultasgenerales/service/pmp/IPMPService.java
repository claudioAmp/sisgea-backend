package ob.unibanca.sicf.consultasgenerales.service.pmp;

import java.util.List;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.pmp.CriterioBusquedaPMP;
import ob.unibanca.sicf.consultasgenerales.model.pmp.PMP;

public interface IPMPService {
	
	List<PMP> buscarTodosPMP();
	
	public Page<PMP> buscarPorCriterios(CriterioBusquedaPMP criterioPaginacion, int pageNo, int pageSize);
	
}
