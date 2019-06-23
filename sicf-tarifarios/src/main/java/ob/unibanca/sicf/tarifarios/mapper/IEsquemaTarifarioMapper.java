package ob.unibanca.sicf.tarifarios.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.EsquemaTarifario;

@Mapper
public interface IEsquemaTarifarioMapper extends IMantenibleMapper<EsquemaTarifario>{
	
	Optional<EsquemaTarifario> buscarEsquemaTarifario(int idEsquema);
}
