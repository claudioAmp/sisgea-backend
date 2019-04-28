package ob.unibanca.sicf.mantenimientosgenerales.service.pais;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Pais;

public interface IPaisService  extends IMantenibleService<Pais>{
	
	List<Pais> buscarTodosPaises();
}
