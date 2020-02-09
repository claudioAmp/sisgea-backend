package edu.taller.sisgea.mantenimientosgenerales.service.pais;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Pais;

public interface IPaisService  extends IMantenibleService<Pais>{
	
	List<Pais> buscarTodosPaises();
}
