package ob.unibanca.sicf.consultasgenerales.service.observada;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.observada.Observada;
import ob.unibanca.sicf.consultasgenerales.model.observada.ObservadaDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.observada.CriterioBusquedaObservada;


public interface IObservadaService {
	
	public Page<Observada> buscarPorCriterios(CriterioBusquedaObservada criterioPaginacion, int pageNo, int pageSize);
	
	ObservadaDetalle buscarDetalle(CriterioBusquedaObservada criterio);
}
