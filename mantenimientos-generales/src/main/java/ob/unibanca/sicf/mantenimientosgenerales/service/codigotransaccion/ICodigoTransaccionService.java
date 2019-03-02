package ob.unibanca.sicf.mantenimientosgenerales.service.codigotransaccion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;

import java.util.List;

public interface ICodigoTransaccionService extends IMantenibleService<CodigoTransaccion> {

    List<CodigoTransaccion> buscarTodosCodigoTransacciones();

    CodigoTransaccion registrarCodigoTransaccion(CodigoTransaccion codigoTransaccion);

    CodigoTransaccion actualizarCodigoTransaccion(int idCodigoTransaccion, CodigoTransaccion codigoTransaccion);

    void eliminarCodigoTransaccion(int idCodigoTransaccion);

}
