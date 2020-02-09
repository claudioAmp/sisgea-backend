package edu.taller.sisgea.tarifarios.mapper;

import edu.taller.sisgea.tarifarios.model.TarifarioEmisor;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioEmisorMapper extends IMantenibleMapper<TarifarioEmisor> {
	
	Optional<TarifarioEmisor> buscarTarifarioEmisor(int idTarifarioEmisor);

}