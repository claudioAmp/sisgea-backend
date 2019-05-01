package ob.unibanca.sicf.tarifarios.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioEmisor;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioEmisorMapper extends IMantenibleMapper<TarifarioEmisor> {
	
	Optional<TarifarioEmisor> buscarTarifarioEmisor(int idTarifarioEmisor);

}