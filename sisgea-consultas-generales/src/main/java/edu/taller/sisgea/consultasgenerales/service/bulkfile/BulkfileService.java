package edu.taller.sisgea.consultasgenerales.service.bulkfile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.IBulkfileMapper;
import edu.taller.sisgea.consultasgenerales.model.bulkfile.Bulkfile;
import edu.taller.sisgea.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.commons.error.exception.RecursoNoEncontradoException;
import edu.taller.sisgea.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
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
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<Bulkfile> buscarPorCriterios(CriterioBusquedaBulkfile criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return bulkfileMapper.buscarPorCriterios(criterioPaginacion);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio) {
		return this.bulkfileMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getTraceNumber()));
	}
	
}
