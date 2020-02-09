package edu.taller.sisgea.mantenimientosgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.TipoCuentaCompensacion;

@Mapper
public interface ITipoCuentaCompensacionMapper extends IMantenibleMapper<TipoCuentaCompensacion> {

}
