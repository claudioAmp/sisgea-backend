package edu.taller.sisgea.conciliacion.mapper;

import edu.taller.sisgea.conciliacion.model.Paquete;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IPaqueteMapper extends IMantenibleMapper<Paquete> {
	
	Optional<Paquete> buscarPaquete(Integer idPaquete);
	
}
