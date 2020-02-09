package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.ipmmc.CriterioBusquedaIpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMcDetalle;

@Mapper
public interface IIpmMcMapper {
	
	public Page<IpmMc> buscarPorCriterios(CriterioBusquedaIpmMc criterioPaginacion);
	
	Optional<IpmMcDetalle> buscarDetalle(CriterioBusquedaIpmMc criterio);
	
}
