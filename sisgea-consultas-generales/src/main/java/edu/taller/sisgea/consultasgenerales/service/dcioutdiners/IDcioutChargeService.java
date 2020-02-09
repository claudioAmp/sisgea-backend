package edu.taller.sisgea.consultasgenerales.service.dcioutdiners;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;

public interface IDcioutChargeService {
	
	public Page<DcioutCharge> buscarPorCriterios(CriterioBusquedaDcioutCharge criterioPaginacion, int pageNo, int pageSize);
	
	DcioutChargeDetalle buscarDetalle(CriterioBusquedaDcioutCharge criterio);
	
}
