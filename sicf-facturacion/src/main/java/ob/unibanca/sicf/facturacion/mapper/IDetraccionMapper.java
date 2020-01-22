package ob.unibanca.sicf.facturacion.mapper;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.facturacion.model.Detraccion;

@Mapper
public interface IDetraccionMapper extends IMantenibleMapper<Detraccion> {
	
}
