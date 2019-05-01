package ob.unibanca.sicf.tarifarios.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioSurcharge;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioSurchargeMapper extends IMantenibleMapper<TarifarioSurcharge> {
	
	Optional<TarifarioSurcharge> buscarTarifarioSurcharge(int idTarifarioSurcharge);

}