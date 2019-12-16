package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinmc.CriterioBusquedaRangoBINMC;
import ob.unibanca.sicf.consultasgenerales.model.rangobinmc.RangoBINMC;

@Mapper
public interface IRangoBINMCMapper {
	
	Page<RangoBINMC> buscarPorCriterios (CriterioBusquedaRangoBINMC criterioPaginacion);
	
	List<RangoBINMC> buscarTodos();

}
