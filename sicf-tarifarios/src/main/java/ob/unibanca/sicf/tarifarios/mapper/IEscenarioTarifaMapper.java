package ob.unibanca.sicf.tarifarios.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.EscenarioTarifa;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IEscenarioTarifaMapper extends IMantenibleMapper<EscenarioTarifa> {
	
	Optional<EscenarioTarifa> buscarEscenarioTarifa(int idEscenarioTarifa);
	
}