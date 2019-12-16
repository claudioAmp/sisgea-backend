package ob.unibanca.sicf.consultasgenerales.service.dcioutdiners;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.IDcioutChargeMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcioutdiners.DcioutCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DcioutChargeService implements IDcioutChargeService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final IDcioutChargeMapper dcioutChargeMapper;
	
	public DcioutChargeService(IDcioutChargeMapper dcioutChargeMapper) {
		this.dcioutChargeMapper = dcioutChargeMapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<DcioutCharge> buscarPorCriterios(CriterioBusquedaDcioutCharge criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return dcioutChargeMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public DcioutChargeDetalle buscarDetalle(CriterioBusquedaDcioutCharge criterio) {
		return this.dcioutChargeMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getIdDciout()));
	}
	
}
