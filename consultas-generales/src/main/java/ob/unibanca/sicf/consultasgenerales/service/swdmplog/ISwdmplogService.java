package ob.unibanca.sicf.consultasgenerales.service.swdmplog;

import java.util.Date;
import java.util.List;

import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;

public interface ISwdmplogService {

	List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda);
	
	TxnSwdmplogDetalle buscarDetallePorCriterios(int idMovTxnSwdmplog, Date fechaProceso);
	
}
