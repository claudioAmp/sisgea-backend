package ob.unibanca.sicf.facturacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.facturacion.model.CodigoFacturacion;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
@Mapper
public interface ICodigoFacturacionMapper extends IMantenibleMapper<CodigoFacturacion> {

	Optional<CodigoFacturacion> buscarUno(int idCodigoFacturacion);
}
