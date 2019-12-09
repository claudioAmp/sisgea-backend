package ob.unibanca.sicf.tarifarios.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioVISA;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ITarifarioVISAMapper extends IMantenibleMapper<TarifarioVISA> {

    Optional<TarifarioVISA> buscarTarifarioVISA (String idTarifarioVisa, Integer idTipoComision);
}
