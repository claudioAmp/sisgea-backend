package ob.unibanca.sicf.mantenimientosgenerales.service.codigotransaccion;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoTransaccionService extends MantenibleService<CodigoTransaccion> implements ICodigoTransaccionService {

    public CodigoTransaccionService(
            @Qualifier("ICodigoTransaccionMapper") IMantenibleMapper<CodigoTransaccion> mantenibleMapper) {
        super(mantenibleMapper);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CodigoTransaccion> buscarTodosCodigoTransacciones() { return super.buscarTodos(); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CodigoTransaccion registrarCodigoTransaccion(CodigoTransaccion codigoTransaccion) {
        super.registrar(codigoTransaccion);
        return codigoTransaccion;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CodigoTransaccion actualizarCodigoTransaccion(int idCodigoTransaccion, CodigoTransaccion codigoTransaccion) {
        codigoTransaccion.setIdCodigoTransaccion(idCodigoTransaccion);
        super.actualizar(codigoTransaccion);
        return codigoTransaccion;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarCodigoTransaccion(int idCodigoTransaccion) {
        CodigoTransaccion codigoTransaccion = CodigoTransaccion.builder().idCodigoTransaccion(idCodigoTransaccion).build();
        super.eliminar(codigoTransaccion);
    }
}
