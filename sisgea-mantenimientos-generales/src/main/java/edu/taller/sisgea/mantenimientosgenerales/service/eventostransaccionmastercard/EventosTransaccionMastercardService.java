package edu.taller.sisgea.mantenimientosgenerales.service.eventostransaccionmastercard;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosTransaccionMastercard;

@Service
public class EventosTransaccionMastercardService extends MantenibleService<EventosTransaccionMastercard> implements IEventosTransaccionMastercardService{
	
	public EventosTransaccionMastercardService(@Qualifier("IEventosTransaccionMastercardMapper") IMantenibleMapper<EventosTransaccionMastercard> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosTransaccionMastercard> buscarTodosEventosTransaccionMastercard() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EventosTransaccionMastercard registrarEventosTransaccionMastercard(EventosTransaccionMastercard eventosTransaccionMastercard) {
		this.registrar(eventosTransaccionMastercard);
		return this.buscarUno(eventosTransaccionMastercard).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EventosTransaccionMastercard actualizarEventosTransaccionMastercard(EventosTransaccionMastercard eventosTransaccionMastercard) {
		this.actualizar(eventosTransaccionMastercard);
		return this.buscarUno(eventosTransaccionMastercard).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarEventosTransaccionMastercard(EventosTransaccionMastercard eventosTransaccionMastercard) {
		this.eliminar(eventosTransaccionMastercard);
		
	}

	
	
}
