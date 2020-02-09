package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.Institucion;
import edu.taller.sisgea.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IInstitucionMapper extends IMantenibleMapper<Institucion> {

	Optional<Institucion> buscarInstitucion(int idInstitucion);
	
	List<Institucion> buscarPorCriterios(CriterioBusquedaInstitucion criterio);
}
