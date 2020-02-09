package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.List;

import edu.taller.sisgea.consultasgenerales.model.rangobinmc.RangoBINMC;
import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.rangobinmc.CriterioBusquedaRangoBINMC;
import edu.taller.sisgea.consultasgenerales.model.rangobinmc.RangoBINMC;

@Mapper
public interface IRangoBINMCMapper {
	
	Page<RangoBINMC> buscarPorCriterios (CriterioBusquedaRangoBINMC criterioPaginacion);
	
	List<RangoBINMC> buscarTodos();

}
