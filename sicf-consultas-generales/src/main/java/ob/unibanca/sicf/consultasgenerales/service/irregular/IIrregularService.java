package ob.unibanca.sicf.consultasgenerales.service.irregular;


import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import ob.unibanca.sicf.consultasgenerales.model.irregular.Irregular;



public interface IIrregularService {


	public Page<Irregular> buscarPorCriteriosIrregulares(CriterioBusquedaIrregular criterio , int pageNo, int pageSize);
}
