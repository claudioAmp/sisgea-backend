package ob.unibanca.sicf.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcioutdiners.DcioutCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IDcioutChargeMapper {
	
	Page<DcioutCharge> buscarPorCriterios(CriterioBusquedaDcioutCharge criterioPaginacion);
	
	Optional<DcioutChargeDetalle> buscarDetalle(CriterioBusquedaDcioutCharge criterio);
	
}
