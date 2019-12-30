package ob.unibanca.sicf.mantenimientosgenerales.service.region;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Region;

public interface IRegionService  extends IMantenibleService<Region>{
	
	List<Region> buscarTodosRegiones();
}
