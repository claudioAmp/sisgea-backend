package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.DistribucionComision;

@Mapper
public interface IDistribucionComisionMapper extends IMantenibleMapper<DistribucionComision>{
	
	Optional<DistribucionComision> buscarDistribucionComision(int idDistribucionComision);
	
}
