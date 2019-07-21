package ob.unibanca.sicf.consultasgenerales.service.bulkfile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.consultasgenerales.mapper.IBulkfileMapper;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.Bulkfile;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;

@Service
public class BulkfileService implements  IBulkfileService{
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final IBulkfileMapper bulkfileMapper;
	
	public BulkfileService(IBulkfileMapper bulkfileMapper) {
		this.bulkfileMapper = bulkfileMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Bulkfile> buscarPorCriterios(CriterioBusquedaBulkfile criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return bulkfileMapper.buscarPorCriterios(criterioPaginacion);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		System.out.println(criterio);
		return this.bulkfileMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getTraceNumber()));
	}
	
}
