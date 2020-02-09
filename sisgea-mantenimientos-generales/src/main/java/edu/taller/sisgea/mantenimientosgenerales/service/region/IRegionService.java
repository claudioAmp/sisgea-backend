package edu.taller.sisgea.mantenimientosgenerales.service.region;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Region;

public interface IRegionService  extends IMantenibleService<Region>{
	
	List<Region> buscarTodosRegiones();
}
