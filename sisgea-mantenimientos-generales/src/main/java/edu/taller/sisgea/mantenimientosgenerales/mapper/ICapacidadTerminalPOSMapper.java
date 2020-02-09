package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.CapacidadTerminalPOS;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ICapacidadTerminalPOSMapper extends IMantenibleMapper<CapacidadTerminalPOS> {
	
	Optional<CapacidadTerminalPOS> buscarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS);

    List<CapacidadTerminalPOS> buscarCapacidadesTerminalesPOSPorMembresia(String idMembresia);
}
