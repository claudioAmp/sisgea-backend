package ob.unibanca.sicf.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import ob.unibanca.sicf.consultasgenerales.model.dcindiners.DcinCharge;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDcinChargeMapper {
	
	Page<DcinCharge> buscarPorCriterios(CriterioBusquedaDcinCharge criterioPaginacion);
	
	//Optional<BulkfileDetalle> buscarDetalle(CriterioBusquedaBulkfile criterio);
}
