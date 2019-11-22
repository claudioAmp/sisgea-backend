package ob.unibanca.sicf.mantenimientosgenerales.service.binvisa;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IBINVisaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.BINVisa;

@Service
public class BINVisaService extends MantenibleService<BINVisa> implements IBINVisaService {

	private final IBINVisaMapper binVisaMapper; 
	
	public BINVisaService(@Qualifier("IBINVisaMapper") IMantenibleMapper<BINVisa> mantenibleMapper) {
		super(mantenibleMapper);
		this.binVisaMapper = (IBINVisaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<BINVisa> buscarTodosBINVisa() {
		return this.buscarTodos();
	}
	
}
