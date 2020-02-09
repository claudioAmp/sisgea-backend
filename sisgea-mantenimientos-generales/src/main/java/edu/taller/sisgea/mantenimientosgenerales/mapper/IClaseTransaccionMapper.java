package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.ClaseTransaccion;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface IClaseTransaccionMapper extends IMantenibleMapper<ClaseTransaccion> {

}
