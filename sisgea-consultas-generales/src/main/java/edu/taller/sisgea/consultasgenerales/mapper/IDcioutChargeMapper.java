package edu.taller.sisgea.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcioutdiners.CriterioBusquedaDcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutCharge;
import edu.taller.sisgea.consultasgenerales.model.dcioutdiners.DcioutChargeDetalle;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IDcioutChargeMapper {
	
	Page<DcioutCharge> buscarPorCriterios(CriterioBusquedaDcioutCharge criterioPaginacion);
	
	Optional<DcioutChargeDetalle> buscarDetalle(CriterioBusquedaDcioutCharge criterio);
	
}
