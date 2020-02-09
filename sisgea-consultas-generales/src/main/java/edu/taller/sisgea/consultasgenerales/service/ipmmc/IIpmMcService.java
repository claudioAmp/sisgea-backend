package edu.taller.sisgea.consultasgenerales.service.ipmmc;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMcDetalle;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMc;
import edu.taller.sisgea.consultasgenerales.model.ipmmc.IpmMcDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.ipmmc.CriterioBusquedaIpmMc;

public interface IIpmMcService {
	
	public Page<IpmMc> buscarPorCriterios(CriterioBusquedaIpmMc criterioPaginacion, int pageNo, int pageSize);
	
	IpmMcDetalle buscarDetalle(CriterioBusquedaIpmMc criterio);
	
}
