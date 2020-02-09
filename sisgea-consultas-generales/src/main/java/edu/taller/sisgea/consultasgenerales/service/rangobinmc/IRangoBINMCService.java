package edu.taller.sisgea.consultasgenerales.service.rangobinmc;

import java.util.List;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.rangobinmc.CriterioBusquedaRangoBINMC;
import edu.taller.sisgea.consultasgenerales.model.rangobinmc.RangoBINMC;

public interface IRangoBINMCService {
	List<RangoBINMC> buscarTodosRangoBINMC();
	public Page<RangoBINMC> buscarPorCriterios (CriterioBusquedaRangoBINMC criterioPaginacion, int pageNo, int pageSize);
}
