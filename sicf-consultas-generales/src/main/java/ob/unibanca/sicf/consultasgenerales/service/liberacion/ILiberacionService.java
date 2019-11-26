package ob.unibanca.sicf.consultasgenerales.service.liberacion;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.liberacion.Liberacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;

public interface ILiberacionService {
	
	public Page<Liberacion> buscarPorCriterios(CriterioBusquedaLiberacion criterioPaginacion, int pageNo, int pageSize);
	
}
