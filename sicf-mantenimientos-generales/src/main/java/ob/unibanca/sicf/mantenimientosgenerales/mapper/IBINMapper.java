package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN;
import ob.unibanca.sicf.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IBINMapper extends IMantenibleMapper<BIN> {
	
	Optional<BIN> buscarBIN(String idBIN);
	
	List<BIN> buscarPorInstituciones(CriterioBusquedaInstitucion criterio);
}
