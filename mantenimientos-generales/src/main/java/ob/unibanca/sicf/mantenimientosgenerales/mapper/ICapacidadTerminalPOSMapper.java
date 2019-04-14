package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CapacidadTerminalPOS;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICapacidadTerminalPOSMapper extends IMantenibleMapper<CapacidadTerminalPOS> {
	
	Optional<CapacidadTerminalPOS> buscarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS);

    List<CapacidadTerminalPOS> buscarCapacidadTerminalPOSPorMembresia(String idMembresia);
    
}
