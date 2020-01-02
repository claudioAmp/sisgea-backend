package ob.unibanca.sicf.consultasgenerales.service.establecimientodcp;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientodcp.CriterioBusquedaEstablecimientoDcp;
import ob.unibanca.sicf.consultasgenerales.model.establecimientodcp.EstablecimientoDcp;

public interface IEstablecimientoDcpService {

    public Page<EstablecimientoDcp> buscarPorCriterios(CriterioBusquedaEstablecimientoDcp criterioPaginacion, int pageNo, int pageSize);
}
