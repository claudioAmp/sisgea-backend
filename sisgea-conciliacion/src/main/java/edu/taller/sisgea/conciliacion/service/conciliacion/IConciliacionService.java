package edu.taller.sisgea.conciliacion.service.conciliacion;

import edu.taller.sisgea.conciliacion.model.Conciliacion;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IConciliacionService extends IMantenibleService<Conciliacion> {

    List<Conciliacion> buscarTodosConciliaciones();

    Conciliacion buscarConciliacion(Integer idConciliacion, Integer idPaquete);
    
    List<Conciliacion> buscarConciliacionPorPaquete(Integer idPaquete);

    Conciliacion registrarConciliacion(Integer idPaquete, Conciliacion conciliacion);

    Conciliacion actualizarConciliacion(Integer idConciliacion, Integer idPaquete,Conciliacion conciliacion);

    void eliminarConciliacion(Integer idConciliacion, Integer idPaquete);

}
