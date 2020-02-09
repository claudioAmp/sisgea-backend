package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.ModoEntradaPOS;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IModoEntradaPOSMapper extends IMantenibleMapper<ModoEntradaPOS> {
	
	Optional<ModoEntradaPOS> buscarModoEntradaPOS(String idMembresia, String idModoEntradaPOS);

    List<ModoEntradaPOS> buscarModosEntradasPOSPorMembresia(String idMembresia);
    
}
