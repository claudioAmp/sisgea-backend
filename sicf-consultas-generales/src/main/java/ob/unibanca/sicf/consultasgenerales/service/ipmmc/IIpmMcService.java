package ob.unibanca.sicf.consultasgenerales.service.ipmmc;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.ipmmc.IpmMc;
import ob.unibanca.sicf.consultasgenerales.model.ipmmc.IpmMcDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.ipmmc.CriterioBusquedaIpmMc;

public interface IIpmMcService {
	
	public Page<IpmMc> buscarPorCriterios(CriterioBusquedaIpmMc criterioPaginacion, int pageNo, int pageSize);
	
	IpmMcDetalle buscarDetalle(CriterioBusquedaIpmMc criterio);
	
}
