package edu.taller.sisgea.consultasgenerales.service.liberacion;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;
import edu.taller.sisgea.consultasgenerales.model.liberacion.Liberacion;
import edu.taller.sisgea.consultasgenerales.model.liberacion.Liberacion;
import edu.taller.sisgea.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;

public interface ILiberacionService {
	
	public Page<Liberacion> buscarPorCriterios(CriterioBusquedaLiberacion criterioPaginacion, int pageNo, int pageSize);
	
}
