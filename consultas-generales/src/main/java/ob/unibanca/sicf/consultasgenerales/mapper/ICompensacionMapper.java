package ob.unibanca.sicf.consultasgenerales.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.compensacion.ComisCompensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.Compensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.CompensacionDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;

@Mapper
public interface ICompensacionMapper {
		
	public Page<Compensacion> buscarPorCriterios(CriterioBusquedaCompensacion criterioPaginacion);
	
	Optional<CompensacionDetalle> buscarPorSecuencia(CriterioBusquedaCompensacion criterio);
	
	List<ComisCompensacion> buscarComisionesPorSecuencia(CriterioBusquedaCompensacion criterio);
	
}
