package edu.taller.sisgea.consultasgenerales.service.swdmplog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.taller.sisgea.consultasgenerales.mapper.ISwdmplogMapper;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplog;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.truncadorpan.annotation.TruncablePAN;
import edu.taller.sisgea.consultasgenerales.mapper.ISwdmplogMapper;
import edu.taller.sisgea.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplog;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SwdmplogService implements ISwdmplogService {
	
	private static final String TXN_NO_ENCONTRADA = "No existe una transacción con identificación de secuencia: %s";
	private final ISwdmplogMapper swdmplogMapper;
	
	public SwdmplogService(ISwdmplogMapper swdmplogMapper) {
		this.swdmplogMapper = swdmplogMapper;
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda) {
		return this.swdmplogMapper.buscarPorCriterios(criterioBusqueda);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<TxnSwdmplog> buscarPaginada(CriterioBusquedaSwdmplog criterioPaginacion, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return swdmplogMapper.buscarPaginada(criterioPaginacion);
	}
	
	//@TruncablePAN
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TxnSwdmplogDetalle buscarDetalle(CriterioBusquedaSwdmplog criterio) {
		return this.swdmplogMapper.buscarDetalle(criterio).orElseThrow(
				() -> new RecursoNoEncontradoException(TXN_NO_ENCONTRADA, criterio.getIdMovTxnSwdmplog()));
	}
}
