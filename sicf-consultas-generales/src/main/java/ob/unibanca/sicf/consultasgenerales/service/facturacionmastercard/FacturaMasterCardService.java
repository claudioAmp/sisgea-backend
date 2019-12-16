package ob.unibanca.sicf.consultasgenerales.service.facturacionmastercard;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IFacturaMasterCardMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.facturamastercard.CriterioBusquedaFacturaMasterCard;
import ob.unibanca.sicf.consultasgenerales.model.facturamastercard.FacturaMasterCard;

@Service
public class FacturaMasterCardService implements  IFacturaMasterCardService{

	private final IFacturaMasterCardMapper facturaMapper;

	public FacturaMasterCardService(IFacturaMasterCardMapper facturaMapper) {
		this.facturaMapper = facturaMapper;
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<FacturaMasterCard> buscarPorCriterios(CriterioBusquedaFacturaMasterCard criterioPaginacion, int pageNo,
			int pageSize) {
			PageHelper.startPage(pageNo, pageSize);
		
		return facturaMapper.buscarPorCriterios(criterioPaginacion);
	}

}
