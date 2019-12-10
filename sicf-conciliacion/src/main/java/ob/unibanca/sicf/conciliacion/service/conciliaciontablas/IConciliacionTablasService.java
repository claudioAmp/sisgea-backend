package ob.unibanca.sicf.conciliacion.service.conciliaciontablas;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.conciliacion.model.ConciliacionTablas;

import java.util.List;

public interface IConciliacionTablasService extends IMantenibleService<ConciliacionTablas> {

    List<ConciliacionTablas> buscarTodosConciliacionTablas();

    ConciliacionTablas buscarConciliacionTablas(Integer idConcTabla, Integer idConciliacion);
    
    List<ConciliacionTablas> buscarConciliacionTablasPorConciliacion(Integer idConciliacion);

    ConciliacionTablas registrarConciliacionTablas(Integer idConciliacion, ConciliacionTablas conciliacionTablas);

    ConciliacionTablas actualizarConciliacionTablas(Integer idConcTabla, Integer idConciliacion,ConciliacionTablas conciliacionTablas);

    void eliminarConciliacionTablas(Integer idConcTabla, Integer idConciliacion);

}
