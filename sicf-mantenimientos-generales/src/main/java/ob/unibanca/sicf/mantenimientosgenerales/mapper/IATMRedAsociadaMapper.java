package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ATMRedAsociada;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IATMRedAsociadaMapper extends IMantenibleMapper<ATMRedAsociada> {
	
	Optional<ATMRedAsociada> buscarATMRedAsociada(int idATM, int idInstitucion);
	
	List<ATMRedAsociada> buscarATMsRedAsociadaPorInstitucion(int idInstitucion);
}
