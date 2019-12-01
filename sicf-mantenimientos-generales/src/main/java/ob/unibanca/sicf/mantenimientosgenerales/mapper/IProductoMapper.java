package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Producto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IProductoMapper extends IMantenibleMapper<Producto> {
}
