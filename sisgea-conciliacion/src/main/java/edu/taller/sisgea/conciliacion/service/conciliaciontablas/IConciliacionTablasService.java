package edu.taller.sisgea.conciliacion.service.conciliaciontablas;

import edu.taller.sisgea.conciliacion.model.ConciliacionTablas;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IConciliacionTablasService extends IMantenibleService<ConciliacionTablas> {

    List<ConciliacionTablas> buscarTodosConciliacionTablas();

    ConciliacionTablas buscarConciliacionTablas(Integer idConcTabla, Integer idConciliacion);
    
    List<ConciliacionTablas> buscarConciliacionTablasPorConciliacion(Integer idConciliacion);

    ConciliacionTablas registrarConciliacionTablas(Integer idConciliacion, ConciliacionTablas conciliacionTablas);

    ConciliacionTablas actualizarConciliacionTablas(Integer idConcTabla, Integer idConciliacion,ConciliacionTablas conciliacionTablas);

    void eliminarConciliacionTablas(Integer idConcTabla, Integer idConciliacion);

}
