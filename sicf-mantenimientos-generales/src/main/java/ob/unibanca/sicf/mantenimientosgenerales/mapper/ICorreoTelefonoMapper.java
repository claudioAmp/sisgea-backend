package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CorreoTelefono;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICorreoTelefonoMapper extends IMantenibleMapper<CorreoTelefono> {
	
	Optional<CorreoTelefono> buscarCorreoTelefono(String idMembresia, String idCorreoTelefono);

    List<CorreoTelefono> buscarCorreosTelefonosPorMembresia(String idMembresia);
   
}
