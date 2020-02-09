package edu.taller.sisgea.tarifarios.mapper;

import edu.taller.sisgea.tarifarios.model.TarifarioSurcharge;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioSurchargeMapper extends IMantenibleMapper<TarifarioSurcharge> {
	
	Optional<TarifarioSurcharge> buscarTarifarioSurcharge(int idTarifarioSurcharge);

}