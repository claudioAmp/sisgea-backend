package ob.unibanca.sicf.consultasgenerales.service.rangobinmc;

import java.util.List;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinmc.CriterioBusquedaRangoBINMC;
import ob.unibanca.sicf.consultasgenerales.model.rangobinmc.RangoBINMC;

public interface IRangoBINMCService {
	List<RangoBINMC> buscarTodosRangoBINMC();
	public Page<RangoBINMC> buscarPorCriterios (CriterioBusquedaRangoBINMC criterioPaginacion, int pageNo, int pageSize);
}
