package ob.unibanca.sicf.consultasgenerales.service.facturacionmastercard;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.facturamastercard.CriterioBusquedaFacturaMasterCard;
import ob.unibanca.sicf.facturacion.model.FacturaMasterCard;


public interface IFacturaMasterCardService {
	public Page<FacturaMasterCard> buscarPorCriterios(CriterioBusquedaFacturaMasterCard criterioPaginacion, int pageNo, int pageSize);

}
 