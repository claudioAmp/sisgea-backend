package ob.unibanca.sicf.mantenimientosgenerales.service.rangobinvisa;


import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.RangoBINVisa;

public interface IRangoBINVisaService extends IMantenibleService<RangoBINVisa>{

	List<RangoBINVisa> buscarTodosRangoBINVisa();
	
}
