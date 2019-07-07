package ob.unibanca.sicf.consultasgenerales.service.swdmplog;

import java.util.List;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.Pagina;
import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;

public interface ISwdmplogService {

	List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda);
	
	Page<TxnSwdmplog> buscarPaginada(CriterioBusquedaSwdmplog criterioPaginacion, int pageNo, int pageSize);
	
	TxnSwdmplogDetalle buscarDetalle(CriterioBusquedaSwdmplog criterio);	
}
