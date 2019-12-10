package ob.unibanca.sicf.tarifarios.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioMiembro;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioMiembroMapper extends IMantenibleMapper<TarifarioMiembro> {
	
	Optional<TarifarioMiembro> buscarTarifarioMiembro(Integer idTarifarioMiembro);
}