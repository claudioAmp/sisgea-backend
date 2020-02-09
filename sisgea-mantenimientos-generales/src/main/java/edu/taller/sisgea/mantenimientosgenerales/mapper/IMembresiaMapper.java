package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.Membresia;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMembresiaMapper extends IMantenibleMapper<Membresia> {

}
