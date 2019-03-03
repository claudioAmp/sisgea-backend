package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ICodigoTransaccionMapper extends IMantenibleMapper<CodigoTransaccion> {

    Optional<CodigoTransaccion> buscarUno(int idClaseTransaccion, int idCodigoTransaccion);

}
