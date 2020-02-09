package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.Conciliacion;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IConciliacionMapper extends IMantenibleMapper<Conciliacion> {
	
	Optional<Conciliacion> buscarConciliacion(Integer idConciliacion, Integer idPaquete);
	
	List<Conciliacion> buscarConciliacionPorPaquete(Integer idPaquete);
	
}
