package edu.taller.sisgea.mantenimientosgenerales.service.programacion;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Programacion;

import java.util.List;

public interface IProgramacionService extends IMantenibleService<Programacion> {
	
	List<Programacion> buscarTodosProgramacion();
	
	Programacion buscarProgramacion(String idCurso, Integer seccion);
	
}