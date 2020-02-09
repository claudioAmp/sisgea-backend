package edu.taller.sisgea.tarifarios.mapper;

import edu.taller.sisgea.tarifarios.model.EscenarioTarifa;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IEscenarioTarifaMapper extends IMantenibleMapper<EscenarioTarifa> {
	
	Optional<EscenarioTarifa> buscarEscenarioTarifa(int idEscenarioTarifa);
	
}