package ob.unibanca.sicf.mantenimientosgenerales.service.rangobinmc;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IRangoBinMasterCardMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.RangoBINMasterCard;

@Service
public class RangoBinMasterCardService extends MantenibleService <RangoBINMasterCard> implements IRangoBinMasterCardService {

	private final IRangoBinMasterCardMapper rangoBinMasterCard;
	
	public RangoBinMasterCardService(@Qualifier("IRangoBinMasterCardMapper") IMantenibleMapper<RangoBINMasterCard> mantenibleMapper) {
		super(mantenibleMapper);
		this.rangoBinMasterCard = (IRangoBinMasterCardMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<RangoBINMasterCard> buscarTodosBinesMasterCard() {
		return this.buscarTodos();
	}

}
