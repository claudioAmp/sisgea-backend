package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.InstitucionTransaccion;

@Mapper
public interface IInstitucionTransaccionMapper extends IMantenibleMapper<InstitucionTransaccion> {

	Optional<InstitucionTransaccion> buscarUno(int idInstitucion, int idClaseTransaccion, int idCodigoTransaccion);
}
