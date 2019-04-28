package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Date;
import java.util.List;

import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;

@Mapper
public interface ISwdmplogMapper {

	List<TxnSwdmplog> buscarPorCriterios(@Param("criterioBusqueda") CriterioBusquedaSwdmplog criterioBusqueda);
	
	TxnSwdmplogDetalle buscarDetallePorCriterios(@Param("idMovTxnSwdmplog") int idMovTxnSwdmplog,
	                                             @Param("fechaProceso") Date fechaProceso);
	
}
