package ob.unibanca.sicf.consultasgenerales.service.swdmplog;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import ob.unibanca.sicf.consultasgenerales.mapper.ISwdmplogMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;

@Service
public class SwdmplogService implements ISwdmplogService {
	
	private final ISwdmplogMapper swdmplogMapper;
	
	public SwdmplogService(ISwdmplogMapper swdmplogMapper) {
		this.swdmplogMapper = swdmplogMapper;
	}

	@Override
	public List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda) {
		PageHelper.startPage(criterioBusqueda.getPageNum(), criterioBusqueda.getPageSize());
		return this.swdmplogMapper.buscarPorCriterios(criterioBusqueda);
	}
}
