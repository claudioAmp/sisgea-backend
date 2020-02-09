package edu.taller.sisgea.mantenimientosgenerales.service.eventosinstitucionmastercard;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.mapper.IEventosInstitucionMastercardMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosInstitucionMastercard;

@Service
public class EventosInstitucionMastercardService extends MantenibleService<EventosInstitucionMastercard> implements IEventosInstitucionMastercardService {
	
	private final IEventosInstitucionMastercardMapper eventosInstitucionMastercardMapper;
	
	public EventosInstitucionMastercardService(@Qualifier("IEventosInstitucionMastercardMapper") IMantenibleMapper<EventosInstitucionMastercard> mantenibleMapper) {
		super(mantenibleMapper);
		this.eventosInstitucionMastercardMapper = (IEventosInstitucionMastercardMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosInstitucionMastercard> buscarTodosEventosInstitucionMastercard() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosInstitucionMastercard> buscarPorInstEventosInstitucionMastercard(Integer idInstitucion){
		return this.eventosInstitucionMastercardMapper.buscarPorInst(idInstitucion); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EventosInstitucionMastercard> registrarEventosInstitucionMastercard(EventosInstitucionMastercard eventosInstitucionMastercard) {
		System.out.println(eventosInstitucionMastercard);
		this.registrar(eventosInstitucionMastercard);
		return this.eventosInstitucionMastercardMapper.buscarPorInst(eventosInstitucionMastercard.getIdInstitucion()); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EventosInstitucionMastercard> actualizarEventosInstitucionMastercard(EventosInstitucionMastercard eventosInstitucionMastercard) {
		System.out.println(eventosInstitucionMastercard);
		this.registrar(eventosInstitucionMastercard);
		return this.eventosInstitucionMastercardMapper.buscarPorInst(eventosInstitucionMastercard.getIdInstitucion());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarEventosInstitucionMastercard(EventosInstitucionMastercard eventosInstitucionMastercard) {
		this.eliminar(eventosInstitucionMastercard);
		
	}
}
