package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.InstitucionTransaccion;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface IInstitucionTransaccionMapper extends IMantenibleMapper<InstitucionTransaccion> {
	
	Optional<InstitucionTransaccion> buscarInstitucionTransaccion(int idInstitucion, int idClaseTransaccion,
	                                                              int idCodigoTransaccion);
}
