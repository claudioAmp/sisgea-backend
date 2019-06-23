package ob.unibanca.sicf.mantenimientosgenerales.service.indlimitepiso;

import java.util.List;
import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.IndLimitePiso;

public interface IIndLimitePisoService extends IMantenibleService<IndLimitePiso>{
	
	List<IndLimitePiso> buscarTodosIndLimitePiso();
}
