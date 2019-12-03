package ob.unibanca.sicf.conciliacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.conciliacion.model.ConciliacionTablas;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IConciliacionTablasMapper extends IMantenibleMapper<ConciliacionTablas> {
	
	Optional<ConciliacionTablas> buscarConciliacionTablas(Integer idConcTabla, Integer idConciliacion);
	
	List<ConciliacionTablas> buscarConciliacionTablasPorConciliacion(Integer idConciliacion);
	
}
