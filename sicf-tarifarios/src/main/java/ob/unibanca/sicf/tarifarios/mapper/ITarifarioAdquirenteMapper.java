package ob.unibanca.sicf.tarifarios.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioAdquirente;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioAdquirenteMapper extends IMantenibleMapper<TarifarioAdquirente> {
	
	Optional<TarifarioAdquirente> buscarTarifarioAdquirente(int idTarifarioAdquirente);

}