package ob.unibanca.sicf.mantenimientosgenerales.service.roltransaccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.RolTransaccion;

@Service
public class RolTransaccionService extends MantenibleService<RolTransaccion> implements IRolTransaccionService {

	public RolTransaccionService(@Qualifier("IRolTransaccionMapper") IMantenibleMapper<RolTransaccion> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<RolTransaccion> buscarTodosRolesTransacciones(){
		return this.buscarTodos();
	}
}
