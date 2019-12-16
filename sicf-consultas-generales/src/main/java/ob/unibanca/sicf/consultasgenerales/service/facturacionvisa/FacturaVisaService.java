package ob.unibanca.sicf.consultasgenerales.service.facturacionvisa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IFacturacionVisaMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.facturavisa.CriterioBusquedaFacturaVisa;
import ob.unibanca.sicf.consultasgenerales.model.facturavisa.FacturaVisa;

@Service
public class FacturaVisaService implements  IFacturaVisaService{

	private final IFacturacionVisaMapper facturaMapper;

	public FacturaVisaService(IFacturacionVisaMapper facturaMapper) {
		this.facturaMapper = facturaMapper;
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<FacturaVisa> buscarPorCriterios(CriterioBusquedaFacturaVisa criterioPaginacion, int pageNo,
			int pageSize) {
			PageHelper.startPage(pageNo, pageSize);
		
		return facturaMapper.buscarPorCriterios(criterioPaginacion);
	}

}
