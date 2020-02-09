package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.MetodoIdThb;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Optional;


 @Mapper
public interface IMetodoIdThbMapper extends IMantenibleMapper<MetodoIdThb> {
    Optional<MetodoIdThb> buscarMetodoIdThb(String idMembresia, String idMetodoIdThb);

    List<MetodoIdThb> buscarMetodoIdThbPorMembresia(String idMembresia);
}
