package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.ATMRedUnicard;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IATMRedUnicardMapper extends IMantenibleMapper<ATMRedUnicard> {
	
	Optional<ATMRedUnicard> buscarATMRedUnicard(int idATM);
}
