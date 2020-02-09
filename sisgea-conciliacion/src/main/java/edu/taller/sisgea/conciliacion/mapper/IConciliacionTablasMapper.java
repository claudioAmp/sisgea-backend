package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.ConciliacionTablas;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IConciliacionTablasMapper extends IMantenibleMapper<ConciliacionTablas> {
	
	Optional<ConciliacionTablas> buscarConciliacionTablas(Integer idConcTabla, Integer idConciliacion);
	
	List<ConciliacionTablas> buscarConciliacionTablasPorConciliacion(Integer idConciliacion);
	
}
