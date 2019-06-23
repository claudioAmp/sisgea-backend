package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.RespuestaMarcaInt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IRespuestaMarcaIntMapper extends IMantenibleMapper<RespuestaMarcaInt> {
	
	Optional<RespuestaMarcaInt> buscarRespuestaMarcaInt(String idMembresia, String idRespuesta);

    List<RespuestaMarcaInt> buscarRespuestasMarcasIntPorMembresia(String idMembresia);
    
}
