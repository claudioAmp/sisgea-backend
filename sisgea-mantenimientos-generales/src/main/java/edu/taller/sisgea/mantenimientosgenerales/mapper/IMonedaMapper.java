package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.Moneda;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMonedaMapper extends IMantenibleMapper<Moneda> {

}
