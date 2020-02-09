package edu.taller.sisgea.mantenimientosgenerales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosVisa;

@Mapper
public interface IEventosVisaMapper extends IMantenibleMapper<EventosVisa> {

    public List<EventosVisa> buscaridDescripcion();
    
    public List<EventosVisa> buscarTodosEventosTransaccionVisaSinTxn();

}
