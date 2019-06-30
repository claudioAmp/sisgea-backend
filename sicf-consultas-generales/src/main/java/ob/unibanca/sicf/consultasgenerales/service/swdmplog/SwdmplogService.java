package ob.unibanca.sicf.consultasgenerales.service.swdmplog;

import java.util.List;

import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.consultasgenerales.mapper.ISwdmplogMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;

@Service
public class SwdmplogService implements ISwdmplogService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final ISwdmplogMapper swdmplogMapper;
	
	public SwdmplogService(ISwdmplogMapper swdmplogMapper) {
		this.swdmplogMapper = swdmplogMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda) {
		return this.swdmplogMapper.buscarPorCriterios(criterioBusqueda);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<TxnSwdmplog> buscarPaginada(CriterioBusquedaSwdmplog criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return swdmplogMapper.buscarPaginada(criterioPaginacion);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TxnSwdmplogDetalle buscarDetalle(CriterioBusquedaSwdmplog criterio) {
		return this.swdmplogMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getIdMovTxnSwdmplog()));
	}
	
}
