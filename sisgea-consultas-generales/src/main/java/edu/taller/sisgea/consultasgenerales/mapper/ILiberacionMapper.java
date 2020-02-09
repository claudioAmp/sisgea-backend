package edu.taller.sisgea.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.liberacion.Liberacion;
import edu.taller.sisgea.consultasgenerales.model.liberacion.Liberacion;
import edu.taller.sisgea.consultasgenerales.model.criterio.liberacion.CriterioBusquedaLiberacion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ILiberacionMapper {
	
	Page<Liberacion> buscarPorCriterios(CriterioBusquedaLiberacion criterioPaginacion);
	
}
