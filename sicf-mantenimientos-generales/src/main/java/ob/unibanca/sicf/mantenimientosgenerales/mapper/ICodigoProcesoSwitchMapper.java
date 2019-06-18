package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ICodigoProcesoSwitchMapper extends IMantenibleMapper<CodigoProcesoSwitch> {

    Optional<CodigoProcesoSwitch> buscarCodigoProcesoSwitch(String idCodigoProcesoSwitch);
}
