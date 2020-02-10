package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.Docente;

import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;

@Mapper
public interface IDocenteMapper extends IMantenibleMapper<Docente> {
	
	Optional<Docente> buscarDocente(String idDocente);
	
}
