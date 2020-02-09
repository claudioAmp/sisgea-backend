package edu.taller.sisgea.consultasgenerales.service.observada;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.observada.CriterioBusquedaObservada;
import edu.taller.sisgea.consultasgenerales.model.observada.Observada;
import edu.taller.sisgea.consultasgenerales.model.observada.ObservadaDetalle;
import edu.taller.sisgea.consultasgenerales.model.observada.Observada;
import edu.taller.sisgea.consultasgenerales.model.observada.ObservadaDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.observada.CriterioBusquedaObservada;


public interface IObservadaService {
	
	public Page<Observada> buscarPorCriterios(CriterioBusquedaObservada criterioPaginacion, int pageNo, int pageSize);
	
	ObservadaDetalle buscarDetalle(CriterioBusquedaObservada criterio);
}
