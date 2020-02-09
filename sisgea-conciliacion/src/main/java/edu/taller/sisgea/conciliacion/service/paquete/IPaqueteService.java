package edu.taller.sisgea.conciliacion.service.paquete;

import edu.taller.sisgea.conciliacion.model.Paquete;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IPaqueteService extends IMantenibleService<Paquete> {

    List<Paquete> buscarTodosPaquetes();

    Paquete buscarPaquete(Integer idPaquete);

    Paquete registrarPaquete(Paquete paquete);

    Paquete actualizarPaquete(Integer idPaquete, Paquete paquete);

    void eliminarPaquete(Integer idPaquete);

}
