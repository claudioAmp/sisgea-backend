package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.List;
import java.util.Optional;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplog;
import edu.taller.sisgea.consultasgenerales.model.swdmplog.TxnSwdmplogDetalle;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;

@Mapper
public interface ISwdmplogMapper {

	List<TxnSwdmplog> buscarPorCriterios(CriterioBusquedaSwdmplog criterioBusqueda);
	
	Page<TxnSwdmplog> buscarPaginada(CriterioBusquedaSwdmplog criterioPaginacion);
	
	Optional<TxnSwdmplogDetalle> buscarDetalle(CriterioBusquedaSwdmplog criterioBusqueda);
	
	Page<TxnSwdmplog> buscarPorFiltrosOrdenamiento(CriterioBusquedaSwdmplog criterioPaginacion);
}
