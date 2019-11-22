package ob.unibanca.sicf.mantenimientosgenerales.service.binvisa;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.BINVisa;
import ob.unibanca.sicf.mantenimientosgenerales.model.BINVisa;

public interface IBINVisaService extends IMantenibleService<BINVisa> {
	
	List<BINVisa> buscarTodosBINVisa();
	
}
