package edu.taller.sisgea.consultasgenerales.service.bulkfile;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.bulkfile.Bulkfile;
import edu.taller.sisgea.consultasgenerales.model.bulkfile.BulkfileDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.bulkfile.CriterioBusquedaBulkfile;


public interface IBulkfileService {
	
	public Page<Bulkfile> buscarPorCriterios(CriterioBusquedaBulkfile criterioPaginacion, int pageNo, int pageSize);
	
	BulkfileDetalle buscarDetalle(CriterioBusquedaBulkfile criterio);
}
