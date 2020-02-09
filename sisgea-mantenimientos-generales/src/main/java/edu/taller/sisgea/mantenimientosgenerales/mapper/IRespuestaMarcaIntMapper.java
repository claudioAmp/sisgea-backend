package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.RespuestaMarcaInt;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IRespuestaMarcaIntMapper extends IMantenibleMapper<RespuestaMarcaInt> {
	
	Optional<RespuestaMarcaInt> buscarRespuestaMarcaInt(String idMembresia, String idRespuesta);

    List<RespuestaMarcaInt> buscarRespuestasMarcasIntPorMembresia(String idMembresia);
    
}
