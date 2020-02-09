package edu.taller.sisgea.consultasgenerales.mapper;

import java.util.List;
import java.util.Optional;

import edu.taller.sisgea.consultasgenerales.model.compensacion.ComisCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.Compensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.CompensacionDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

import edu.taller.sisgea.consultasgenerales.model.compensacion.ComisCompensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.Compensacion;
import edu.taller.sisgea.consultasgenerales.model.compensacion.CompensacionDetalle;
import edu.taller.sisgea.consultasgenerales.model.criterio.compensacion.CriterioBusquedaCompensacion;

@Mapper
public interface ICompensacionMapper {
		
	public Page<Compensacion> buscarPorCriterios(CriterioBusquedaCompensacion criterioPaginacion);
	
	Optional<CompensacionDetalle> buscarPorSecuencia(CriterioBusquedaCompensacion criterio);
	
	List<ComisCompensacion> buscarComisionesPorSecuencia(CriterioBusquedaCompensacion criterio);
	
}
