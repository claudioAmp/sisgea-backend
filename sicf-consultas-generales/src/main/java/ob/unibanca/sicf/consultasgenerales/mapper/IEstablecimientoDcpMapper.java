package ob.unibanca.sicf.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientodcp.CriterioBusquedaEstablecimientoDcp;
import ob.unibanca.sicf.consultasgenerales.model.establecimientodcp.EstablecimientoDcp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IEstablecimientoDcpMapper {

    Page<EstablecimientoDcp> buscarPorCriterios(CriterioBusquedaEstablecimientoDcp criterioPaginacion);
}
