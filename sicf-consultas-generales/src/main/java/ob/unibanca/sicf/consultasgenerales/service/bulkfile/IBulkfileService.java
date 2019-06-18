package ob.unibanca.sicf.consultasgenerales.service.bulkfile;

import com.github.pagehelper.Page;

import ob.unibanca.sicf.consultasgenerales.model.bulkfile.Bulkfile;
import ob.unibanca.sicf.consultasgenerales.model.bulkfile.BulkfileDetalle;
import ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;


public interface IBulkfileService {
	
	public Page<Bulkfile> buscarPorCriterios(CriterioBusquedaBulkfile criterioPaginacion, int pageNo, int pageSize);
	
	BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio);
}
