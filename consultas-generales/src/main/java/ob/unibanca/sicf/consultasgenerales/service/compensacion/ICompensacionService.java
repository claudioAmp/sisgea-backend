package ob.unibanca.sicf.consultasgenerales.service.compensacion;


import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.compensacion.ComisCompensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.Compensacion;
import ob.unibanca.sicf.consultasgenerales.model.compensacion.CompensacionDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;

public interface ICompensacionService {
	
	public Page<Compensacion> buscarPorCriterios(CriterioBusquedaCompensacion criterioPaginacion, int pageNo, int pageSize);
	
	CompensacionDetalle buscarPorSecuencia(CriterioBusquedaCompensacion criterio);
	
	ComisCompensacion buscarComisionesPorSecuencia(CriterioBusquedaCompensacion criterio);
}
