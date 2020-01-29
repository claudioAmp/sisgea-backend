package ob.unibanca.sicf.facturacion.mapper;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.facturacion.model.TipoNota;

@Mapper
public interface ITipoNotaMapper extends IMantenibleMapper<TipoNota> {

}
