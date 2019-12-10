package ob.unibanca.sicf.consultasgenerales.service.dcindiners;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcindiners.DcinCharge;


public interface IDcinChargeService {
	
	public Page<DcinCharge> buscarPorCriterios(CriterioBusquedaDcinCharge criterioPaginacion, int pageNo, int pageSize);
	
	//BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio);
}
