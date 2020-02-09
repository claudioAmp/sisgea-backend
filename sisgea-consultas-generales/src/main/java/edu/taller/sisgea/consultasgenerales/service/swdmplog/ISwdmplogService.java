package edu.taller.sisgea.consultasgenerales.service.swdmplog;

import java.util.List;
import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplog;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;

public interface ISwdmplogService {

	List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda);
	
	Page<TxnSwdmplog> buscarPaginada(CriterioBusquedaSwdmplog criterioPaginacion, int pageNo, int pageSize);
	
	TxnSwdmplogDetalle buscarDetalle(CriterioBusquedaSwdmplog criterio);
}
