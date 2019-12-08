package ob.unibanca.sicf.mantenimientosgenerales.service.eventostransaccionvisa;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosTransaccionVisa;

@Service
public class EventosTransaccionVisaService extends MantenibleService<EventosTransaccionVisa> implements IEventosTransaccionVisaService{
	
	public EventosTransaccionVisaService(@Qualifier("IEventosTransaccionVisaMapper") IMantenibleMapper<EventosTransaccionVisa> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisaes() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EventosTransaccionVisa registrarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa) {
		this.registrar(eventosTransaccionVisa);
		return this.buscarUno(eventosTransaccionVisa).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EventosTransaccionVisa actualizarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa) {
		this.actualizar(eventosTransaccionVisa);
		return this.buscarUno(eventosTransaccionVisa).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa) {
		this.eliminar(eventosTransaccionVisa);
		
	}

	
	
}
