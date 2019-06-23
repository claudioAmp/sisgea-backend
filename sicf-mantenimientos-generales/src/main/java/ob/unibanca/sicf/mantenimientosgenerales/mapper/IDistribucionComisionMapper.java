package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionComision;

@Mapper
public interface IDistribucionComisionMapper extends IMantenibleMapper<DistribucionComision>{
	
	Optional<DistribucionComision> buscarDistribucionComision(int idDistribucionComision);
	
}
