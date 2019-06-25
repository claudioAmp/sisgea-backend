package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import ob.unibanca.sicf.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IInstitucionMapper extends IMantenibleMapper<Institucion> {

	Optional<Institucion> buscarInstitucion(int idInstitucion);
	
	List<Institucion> buscarPorCriterios(CriterioBusquedaInstitucion criterio);
}