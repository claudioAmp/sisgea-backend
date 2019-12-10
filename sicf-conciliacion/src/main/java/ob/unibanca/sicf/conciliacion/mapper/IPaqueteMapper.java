package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.Paquete;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IPaqueteMapper extends IMantenibleMapper<Paquete> {
	
	Optional<Paquete> buscarPaquete(Integer idPaquete);
	
}
