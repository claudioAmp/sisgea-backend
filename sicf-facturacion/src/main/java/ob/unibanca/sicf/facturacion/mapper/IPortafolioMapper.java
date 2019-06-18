package ob.unibanca.sicf.facturacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.facturacion.model.Portafolio;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IPortafolioMapper extends IMantenibleMapper<Portafolio> {

}
