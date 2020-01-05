package ob.unibanca.sicf.consultasgenerales.service.facturacionvisa;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.facturavisa.CriterioBusquedaFacturaVisa;
import ob.unibanca.sicf.facturacion.model.FacturaVisa;


public interface IFacturaVisaService {
	public Page<FacturaVisa> buscarPorCriterios(CriterioBusquedaFacturaVisa criterioPaginacion, int pageNo, int pageSize);

}
 