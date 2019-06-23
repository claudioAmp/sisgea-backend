package ob.unibanca.sicf.mantenimientosgenerales.service.codigoprocesoswitch;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;

import java.util.List;

public interface ICodigoProcesoSwitchService extends IMantenibleService<CodigoProcesoSwitch> {

    List<CodigoProcesoSwitch> buscarTodosCodigoProcesoSwitches();

    CodigoProcesoSwitch buscarCodigoProcesoSwitch(String idCodigoProcesoSwitch);

    CodigoProcesoSwitch registrarCodigoProcesoSwitch(CodigoProcesoSwitch codigoProcesoSwitch);

    CodigoProcesoSwitch actualizarCodigoProcesoSwitch(String idCodigoProcesoSwitch, CodigoProcesoSwitch codigoProcesoSwitch);

    void eliminarCodigoProcesoSwitch(String idCodigoProcesoSwitch);

}
