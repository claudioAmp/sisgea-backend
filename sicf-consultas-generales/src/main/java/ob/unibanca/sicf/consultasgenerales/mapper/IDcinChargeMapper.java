package ob.unibanca.sicf.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcindiners.DcinCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcindiners.DcinChargeDetalle;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IDcinChargeMapper {
	
	Page<DcinCharge> buscarPorCriterios(CriterioBusquedaDcinCharge criterioPaginacion);
	
	Optional<DcinChargeDetalle> buscarDetalle(CriterioBusquedaDcinCharge criterio);
	
}
