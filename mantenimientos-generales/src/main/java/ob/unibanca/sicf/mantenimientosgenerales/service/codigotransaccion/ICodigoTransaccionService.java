package ob.unibanca.sicf.mantenimientosgenerales.service.codigotransaccion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;

import java.util.List;

public interface ICodigoTransaccionService extends IMantenibleService<CodigoTransaccion> {

    List<CodigoTransaccion> buscarTodosCodigoTransacciones();

    CodigoTransaccion buscarCodigoTransaccion(int idClaseTransaccion, int idCodigoTransaccion);

    CodigoTransaccion registrarCodigoTransaccion(CodigoTransaccion codigoTransaccion);

    CodigoTransaccion actualizarCodigoTransaccion(int idClaseTransaccion, int idCodigoTransaccion, CodigoTransaccion codigoTransaccion);

    void eliminarCodigoTransaccion(int idClaseTransaccion, int idCodigoTransaccion);

}
