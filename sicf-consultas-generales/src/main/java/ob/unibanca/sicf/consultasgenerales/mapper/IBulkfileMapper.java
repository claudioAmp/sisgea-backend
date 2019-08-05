package ob.unibanca.sicf.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.Bulkfile;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IBulkfileMapper {
	
	Page<Bulkfile> buscarPorCriterios(CriterioBusquedaBulkfile criterioPaginacion);
	
	Optional<BulkfileDetalle> buscarDetalle(CriterioBusquedaBulkfile criterio);
}
