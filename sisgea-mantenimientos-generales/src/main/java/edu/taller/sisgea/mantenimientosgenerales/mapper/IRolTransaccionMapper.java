package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.RolTransaccion;
import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface IRolTransaccionMapper extends IMantenibleMapper<RolTransaccion> {

}
