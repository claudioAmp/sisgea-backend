package ob.unibanca.sicf.mantenimientosgenerales.service.rangobinmc;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.RangoBINMasterCard;

public interface IRangoBinMasterCardService extends IMantenibleService<RangoBINMasterCard> {
	
	List<RangoBINMasterCard> buscarTodosBinesMasterCard();
	
}
