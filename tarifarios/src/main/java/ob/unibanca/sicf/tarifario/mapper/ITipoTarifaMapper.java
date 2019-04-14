package ob.unibanca.sicf.tarifario.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifario.model.TipoTarifa;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITipoTarifaMapper extends IMantenibleMapper<TipoTarifa> {
	
	Optional<TipoTarifa> buscarTipoTarifa(int idTarifa);
	
}