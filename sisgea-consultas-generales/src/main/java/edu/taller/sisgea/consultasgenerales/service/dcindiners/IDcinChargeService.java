package edu.taller.sisgea.consultasgenerales.service.dcindiners;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinChargeDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinChargeDetalle;

public interface IDcinChargeService {
	
	public Page<DcinCharge> buscarPorCriterios(CriterioBusquedaDcinCharge criterioPaginacion, int pageNo, int pageSize);
	
	DcinChargeDetalle buscarDetalle(CriterioBusquedaDcinCharge criterio);
	
}
