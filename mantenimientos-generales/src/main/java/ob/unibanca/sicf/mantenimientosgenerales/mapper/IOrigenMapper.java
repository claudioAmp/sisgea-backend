package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Origen;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IOrigenMapper extends IMantenibleMapper<Origen> {

	Optional<Origen> buscarUno(int idOrigen);

}
