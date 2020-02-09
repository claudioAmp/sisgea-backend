package edu.taller.sisgea.consultasgenerales.service.binvisa;

import java.util.List;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.binvisa.BINVisa;
import edu.taller.sisgea.consultasgenerales.model.binvisa.BINVisa;
import edu.taller.sisgea.consultasgenerales.model.criterio.binvisa.CriterioBusquedaBinVisa;

public interface IBINVisaService {
	
	List<BINVisa> buscarTodosBINVisa();

	public Page<BINVisa> buscarPorCriterios(CriterioBusquedaBinVisa criterioPaginacion, int pageNo, int pageSize);
	
}
