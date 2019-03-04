package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedUnicard;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IATMRedUnicardMapper extends IMantenibleMapper<ATMRedUnicard> {
	
	Optional<ATMRedUnicard> buscarUno(int idATM);

}
