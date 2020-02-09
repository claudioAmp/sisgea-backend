package edu.taller.sisgea.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.bulkfile.Bulkfile;
import edu.taller.sisgea.consultasgenerales.model.bulkfile.BulkfileDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IBulkfileMapper {
	
	Page<Bulkfile> buscarPorCriterios(CriterioBusquedaBulkfile criterioPaginacion);
	
	Optional<BulkfileDetalle> buscarDetalle(CriterioBusquedaBulkfile criterio);
}
