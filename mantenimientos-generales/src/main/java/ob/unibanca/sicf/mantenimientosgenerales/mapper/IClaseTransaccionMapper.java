package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ClaseTransaccion;

@Mapper
public interface IClaseTransaccionMapper extends IMantenibleMapper<ClaseTransaccion> {

}
