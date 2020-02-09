package edu.taller.sisgea.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinCharge;
import edu.taller.sisgea.consultasgenerales.model.dcindiners.DcinChargeDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.dcindiners.CriterioBusquedaDcinCharge;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IDcinChargeMapper {
	
	Page<DcinCharge> buscarPorCriterios(CriterioBusquedaDcinCharge criterioPaginacion);
	
	Optional<DcinChargeDetalle> buscarDetalle(CriterioBusquedaDcinCharge criterio);
	
}
