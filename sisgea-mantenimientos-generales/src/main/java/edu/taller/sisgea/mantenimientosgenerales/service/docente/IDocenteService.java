package edu.taller.sisgea.mantenimientosgenerales.service.docente;

import edu.taller.sisgea.mantenimientosgenerales.model.Docente;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IDocenteService extends IMantenibleService<Docente> {

    List<Docente> buscarTodosDocentes();

}
