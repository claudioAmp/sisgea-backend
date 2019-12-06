package ob.unibanca.sicf.consultasgenerales.service.dcindiners;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.IDcinChargeMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcindiners.DcinCharge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DcinChargeService implements IDcinChargeService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final IDcinChargeMapper dcinChargeMapper;
	
	public DcinChargeService(IDcinChargeMapper dcinChargeMapper) {
		this.dcinChargeMapper = dcinChargeMapper;
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<DcinCharge> buscarPorCriterios(CriterioBusquedaDcinCharge criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return dcinChargeMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	/*@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		return this.dcinChargeMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getTraceNumber()));
	}*/
	
}
