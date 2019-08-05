package ob.unibanca.sicf.consultasgenerales.service.bulkfile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import ob.unibanca.sicf.consultasgenerales.mapper.IBulkfileMapper;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.Bulkfile;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BulkfileService implements IBulkfileService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final IBulkfileMapper bulkfileMapper;
	
	public BulkfileService(IBulkfileMapper bulkfileMapper) {
		this.bulkfileMapper = bulkfileMapper;
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Bulkfile> buscarPorCriterios(CriterioBusquedaBulkfile criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return bulkfileMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		return this.bulkfileMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getTraceNumber()));
	}
	
}
