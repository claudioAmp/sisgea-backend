package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Servicio;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IServicioMapper extends IMantenibleMapper<Servicio> {
	
	Optional<Servicio> buscarServicio(String idMembresia, String idServicio);

	List<Servicio> buscarServiciosPorMembresia(String idMembresia);
}