package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IBINMapper extends IMantenibleMapper<BIN> {
	
	Optional<BIN> buscarUno(String idBIN);
}
