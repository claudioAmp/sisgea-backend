package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.Programacion;

import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;

@Mapper
public interface IProgramacionMapper extends IMantenibleMapper<Programacion> {
	
	Optional<Programacion> buscarProgramacion(String idCurso, Integer seccion);
	
}
