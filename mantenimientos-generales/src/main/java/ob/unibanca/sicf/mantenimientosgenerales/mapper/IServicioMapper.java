package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Servicio;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IServicioMapper extends IMantenibleMapper<Servicio> {
	
	Optional<Servicio> buscarUno(String idMembresia, String idServicio);
}
