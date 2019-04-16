package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog.CriterioBusquedaSwdmplog;
import ob.unibanca.sicf.consultasgenerales.model.swdmplog.TxnSwdmplog;

@Mapper
public interface ISwdmplogMapper {

	List<TxnSwdmplog> buscarPorCriterios(@Param("criterioBusqueda") CriterioBusquedaSwdmplog criterioBusqueda);
}
