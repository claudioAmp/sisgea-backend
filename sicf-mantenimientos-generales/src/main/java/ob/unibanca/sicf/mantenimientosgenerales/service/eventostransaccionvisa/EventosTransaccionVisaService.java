package ob.unibanca.sicf.mantenimientosgenerales.service.eventostransaccionvisa;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IEventosTransaccionVisaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosTransaccionVisa;

@Service
public class EventosTransaccionVisaService extends MantenibleService<EventosTransaccionVisa> implements IEventosTransaccionVisaService{
	
	private final IEventosTransaccionVisaMapper eventosTransaccionVisaMapper;
	
	public EventosTransaccionVisaService(@Qualifier("IEventosTransaccionVisaMapper") IMantenibleMapper<EventosTransaccionVisa> mantenibleMapper) {
		super(mantenibleMapper);
		this.eventosTransaccionVisaMapper = (IEventosTransaccionVisaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisa() {
		return this.buscarTodos();
	}
		
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisaSinTxn() {
		return this.eventosTransaccionVisaMapper.buscarTodosEventosTransaccionVisaSinTxn();
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
