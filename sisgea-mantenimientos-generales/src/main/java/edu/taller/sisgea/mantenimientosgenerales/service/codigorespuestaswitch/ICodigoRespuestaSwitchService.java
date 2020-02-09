package edu.taller.sisgea.mantenimientosgenerales.service.codigorespuestaswitch;

import edu.taller.sisgea.mantenimientosgenerales.model.CodigoRespuestaSwitch;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ICodigoRespuestaSwitchService extends IMantenibleService<CodigoRespuestaSwitch> {

    List<CodigoRespuestaSwitch> buscarTodosCodigoRespuetaSwitches();

    CodigoRespuestaSwitch registrarCodigoRespuestaSwitch(CodigoRespuestaSwitch codigoRespuestaSwitch);

    CodigoRespuestaSwitch actualizarCodigoRespuestaSwitch(String idCodigoRespuestaSwitch, CodigoRespuestaSwitch codigoRespuestaSwitch);

    void eliminarCodigoRespuestaSwitch(String idCodigoRespuestaSwitch);

}
