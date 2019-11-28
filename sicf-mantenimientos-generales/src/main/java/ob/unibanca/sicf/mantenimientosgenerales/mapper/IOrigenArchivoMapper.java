package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.OrigenArchivo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IOrigenArchivoMapper extends IMantenibleMapper<OrigenArchivo> {
	
	Optional<OrigenArchivo> buscarOrigenArchivo(String idOrigenArchivo);
	
	List<OrigenArchivo> buscarOrigenArchivoPorConciliacion(boolean concilia);
	
}
