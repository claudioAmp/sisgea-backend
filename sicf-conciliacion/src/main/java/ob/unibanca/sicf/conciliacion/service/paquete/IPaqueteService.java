package ob.unibanca.sicf.conciliacion.service.paquete;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.conciliacion.model.Paquete;

import java.util.List;

public interface IPaqueteService extends IMantenibleService<Paquete> {

    List<Paquete> buscarTodosPaquetes();

    Paquete buscarPaquete(Integer idPaquete);

    Paquete registrarPaquete(Paquete paquete);

    Paquete actualizarPaquete(Integer idPaquete, Paquete paquete);

    void eliminarPaquete(Integer idPaquete);

}
