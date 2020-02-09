package edu.taller.sisgea.consultasgenerales.service.compensacion;


import java.util.List;

import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.compensacion.ComisCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.Compensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.CompensacionDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.ComisCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.Compensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.CompensacionDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;

public interface ICompensacionService {
	
	public Page<Compensacion> buscarPorCriterios(CriterioBusquedaCompensacion criterioPaginacion, int pageNo, int pageSize);
	
	CompensacionDetalle buscarPorSecuencia(CriterioBusquedaCompensacion criterio);
	
	List<ComisCompensacion> buscarComisionesPorSecuencia(CriterioBusquedaCompensacion criterio);
}
