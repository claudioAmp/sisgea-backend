package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionFondo;

@Mapper
public interface IDistribucionFondoMapper extends IMantenibleMapper<DistribucionFondo>{
	
	Optional<DistribucionFondo> buscarDistribucionFondo(int idDistribucionFondo);

}
