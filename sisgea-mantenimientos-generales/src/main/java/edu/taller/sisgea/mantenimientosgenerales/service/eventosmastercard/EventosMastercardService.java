package edu.taller.sisgea.mantenimientosgenerales.service.eventosmastercard;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.EventosMastercard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;

@Service
public class EventosMastercardService extends MantenibleService<EventosMastercard> implements IEventosMastercardService {
	
	public EventosMastercardService(@Qualifier("IEventosMastercardMapper") IMantenibleMapper<EventosMastercard> mantenibleMapper) {
		super(mantenibleMapper);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosMastercard> buscarTodosEventosMastercard() {
		return this.buscarTodos();
	}
	
	
}
