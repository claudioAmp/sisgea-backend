package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.ipmmc.CriterioBusquedaIpmMc;
import ob.unibanca.sicf.consultasgenerales.model.ipmmc.IpmMc;
import ob.unibanca.sicf.consultasgenerales.model.ipmmc.IpmMcDetalle;

@Mapper
public interface IIpmMcMapper {
	
	public Page<IpmMc> buscarPorCriterios(CriterioBusquedaIpmMc criterioPaginacion);
	
	Optional<IpmMcDetalle> buscarDetalle(CriterioBusquedaIpmMc criterio);
	
}
