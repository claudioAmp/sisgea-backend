package edu.taller.sisgea.mantenimientosgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosTransaccionMastercard;

@Mapper
public interface IEventosTransaccionMastercardMapper extends IMantenibleMapper<EventosTransaccionMastercard> {
	
}
