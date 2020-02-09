package edu.taller.sisgea.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.CodigoProcesoSwitch;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ICodigoProcesoSwitchMapper extends IMantenibleMapper<CodigoProcesoSwitch> {

    Optional<CodigoProcesoSwitch> buscarCodigoProcesoSwitch(String idCodigoProcesoSwitch);
}
