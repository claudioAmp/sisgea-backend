package ob.unibanca.sicf.consultasgenerales.service.compensacion;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.compensacion.Compensacion;
import ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion.CriterioCompensacion;

public interface ICompensacionService {
	
	public Page<Compensacion> buscarPorCriterios(CriterioCompensacion criterioPaginacion, int pageNo, int pageSize);
}
