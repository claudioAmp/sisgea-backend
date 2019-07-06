package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;
import java.util.Optional;

import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;

@Mapper
public interface ISwdmplogMapper {

	List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda);
	
	Page<TxnSwdmplog> buscarPaginada(CriterioBusquedaSwdmplog criterioPaginacion);
	
	Optional<TxnSwdmplogDetalle> buscarDetalle(CriterioBusquedaSwdmplog criterioBusqueda);
	
	Page<TxnSwdmplog> buscarPorFiltrosOrdenamiento(CriterioBusquedaSwdmplog criterioPaginacion);
}
