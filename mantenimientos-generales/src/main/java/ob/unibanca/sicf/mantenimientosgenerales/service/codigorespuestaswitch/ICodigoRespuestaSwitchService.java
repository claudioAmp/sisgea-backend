package ob.unibanca.sicf.mantenimientosgenerales.service.codigorespuestaswitch;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoRespuestaSwitch;

import java.util.List;

public interface ICodigoRespuestaSwitchService extends IMantenibleService<CodigoRespuestaSwitch> {

    List<CodigoRespuestaSwitch> buscarTodosCodigoRespuetaSwitches();

    CodigoRespuestaSwitch registrarCodigoRespuestaSwitch(CodigoRespuestaSwitch codigoRespuestaSwitch);

    CodigoRespuestaSwitch actualizarCodigoRespuestaSwitch(String idCodigoRespuestaSwitch, CodigoRespuestaSwitch codigoRespuestaSwitch);

    void eliminarCodigoRespuestaSwitch(String idCodigoRespuestaSwitch);

}
