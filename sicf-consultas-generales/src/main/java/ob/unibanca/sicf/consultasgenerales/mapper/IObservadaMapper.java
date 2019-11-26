package ob.unibanca.sicf.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.observada.Observada;
import ob.unibanca.sicf.consultasgenerales.model.observada.ObservadaDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.observada.CriterioBusquedaObservada;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IObservadaMapper {
	
	Page<Observada> buscarPorCriterios(CriterioBusquedaObservada criterioPaginacion);
	
	Optional<ObservadaDetalle> buscarDetalle(CriterioBusquedaObservada criterio);
}
