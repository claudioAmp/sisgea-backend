package ob.unibanca.sicf.mantenimientosgenerales.service.rangobinvisa;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IRangoBINVisaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.RangoBINVisa;

@Service
public class RangoBINVisaService extends MantenibleService<RangoBINVisa> implements IRangoBINVisaService {

	private final IRangoBINVisaMapper rangoBinVisaMapper; 
	
	public RangoBINVisaService(@Qualifier("IRangoBINVisaMapper") IMantenibleMapper<RangoBINVisa> mantenibleMapper) {
		super(mantenibleMapper);
		this.rangoBinVisaMapper = (IRangoBINVisaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<RangoBINVisa> buscarTodosRangoBINVisa() {
		return this.buscarTodos();
	}
	
}
