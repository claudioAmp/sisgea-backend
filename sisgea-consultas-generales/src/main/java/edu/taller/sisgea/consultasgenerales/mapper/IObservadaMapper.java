package edu.taller.sisgea.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.observada.Observada;
import edu.taller.sisgea.consultasgenerales.model.observada.ObservadaDetalle;
import edu.taller.sisgea.consultasgenerales.model.observada.Observada;
import edu.taller.sisgea.consultasgenerales.model.observada.ObservadaDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.observada.CriterioBusquedaObservada;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IObservadaMapper {
	
	Page<Observada> buscarPorCriterios(CriterioBusquedaObservada criterioPaginacion);
	
	Optional<ObservadaDetalle> buscarDetalle(CriterioBusquedaObservada criterio);
}
