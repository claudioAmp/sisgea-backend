package ob.unibanca.sicf.consultasgenerales.service.swdmplog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import ob.unibanca.sicf.consultasgenerales.mapper.ISwdmplogMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Columna;
import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;
import ob.unibanca.sicf.consultasgenerales.util.PaginacionUtils;

@Service
public class SwdmplogService implements ISwdmplogService {
	
	private final ISwdmplogMapper swdmplogMapper;
	
	public SwdmplogService(ISwdmplogMapper swdmplogMapper) {
		this.swdmplogMapper = swdmplogMapper;
	}

	@Override
	public List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda) {
		// filtros=(name=referenceNumber|order=DESC)
		//List<Columna> filtros = PaginacionUtils.getFiltros(criterioBusqueda.getFiltros(), TxnSwdmplog.class);
		//System.out.println(filtros);
		//PageHelper.startPage(criterioBusqueda.getPageNum(), criterioBusqueda.getPageSize());
		//PageHelper.orderBy(PaginacionUtils.getOrderExpression(filtros, "id_mov_txn_swdmplog DESC"));
		return this.swdmplogMapper.buscarPorCriterios(criterioBusqueda);
	}
	
	@Override
	public TxnSwdmplogDetalle buscarDetallePorCriterios(int idMovTxnSwdmplog, Date fechaProceso) {
		return this.swdmplogMapper.buscarDetallePorCriterios(idMovTxnSwdmplog, fechaProceso);
	}
	
	
}
