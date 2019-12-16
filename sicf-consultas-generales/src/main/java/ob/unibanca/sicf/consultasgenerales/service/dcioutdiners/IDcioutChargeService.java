package ob.unibanca.sicf.consultasgenerales.service.dcioutdiners;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcioutdiners.DcioutCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;

public interface IDcioutChargeService {
	
	public Page<DcioutCharge> buscarPorCriterios(CriterioBusquedaDcioutCharge criterioPaginacion, int pageNo, int pageSize);
	
	DcioutChargeDetalle buscarDetalle(CriterioBusquedaDcioutCharge criterio);
	
}
