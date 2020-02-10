package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.Plan;

import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;

@Mapper
public interface IPlanMapper extends IMantenibleMapper<Plan> {
	
	Optional<Plan> buscarPlan(String idPlan);
	
}
