package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.RolTransaccion;

@Mapper
public interface IRolTransaccionMapper extends IMantenibleMapper<RolTransaccion> {

}
