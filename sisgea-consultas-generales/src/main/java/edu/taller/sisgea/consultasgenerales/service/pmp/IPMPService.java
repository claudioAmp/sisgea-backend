package edu.taller.sisgea.consultasgenerales.service.pmp;

import java.util.List;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.pmp.PMP;
import edu.taller.sisgea.consultasgenerales.model.criterio.pmp.CriterioBusquedaPMP;
import edu.taller.sisgea.consultasgenerales.model.pmp.PMP;

public interface IPMPService {
	
	List<PMP> buscarTodosPMP();
	
	public Page<PMP> buscarPorCriterios(CriterioBusquedaPMP criterioPaginacion, int pageNo, int pageSize);
	
}
