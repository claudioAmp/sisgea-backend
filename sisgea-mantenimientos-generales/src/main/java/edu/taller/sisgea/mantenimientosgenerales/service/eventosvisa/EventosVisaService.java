package edu.taller.sisgea.mantenimientosgenerales.service.eventosvisa;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IEventosVisaMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosVisa;

@Service
public class EventosVisaService extends MantenibleService<EventosVisa> implements IEventosVisaService {

	IEventosVisaMapper eventosVisaMapper;
	
	public EventosVisaService(@Qualifier("IEventosVisaMapper") IMantenibleMapper<EventosVisa> mantenibleMapper) {
		super(mantenibleMapper);
		eventosVisaMapper = (IEventosVisaMapper) mantenibleMapper;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosVisa> buscarTodosEventosVisa() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosVisa> buscarTodosEventosTransaccionVisaSinTxn() {
		return this.eventosVisaMapper.buscarTodosEventosTransaccionVisaSinTxn();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosVisa> buscaridDescripcionEventosVisa() {
		return this.eventosVisaMapper.buscaridDescripcion();
	}
	
}
