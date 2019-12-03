package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.Conciliacion;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IConciliacionMapper extends IMantenibleMapper<Conciliacion> {
	
	Optional<Conciliacion> buscarConciliacion(Integer idConciliacion, Integer idPaquete);
	
	List<Conciliacion> buscarConciliacionPorPaquete(Integer idPaquete);
	
}
