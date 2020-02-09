package edu.taller.sisgea.mantenimientosgenerales.service.eventosinstitucionvisa;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.EventosInstitucionVisa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.mapper.IEventosInstitucionVisaMapper;

@Service
public class EventosInstitucionVisaService extends MantenibleService<EventosInstitucionVisa> implements IEventosInstitucionVisaService {
	
	private final IEventosInstitucionVisaMapper eventosInstitucionVisaMapper;
	
	public EventosInstitucionVisaService(@Qualifier("IEventosInstitucionVisaMapper") IMantenibleMapper<EventosInstitucionVisa> mantenibleMapper) {
		super(mantenibleMapper);
		this.eventosInstitucionVisaMapper = (IEventosInstitucionVisaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosInstitucionVisa> buscarTodosEventosInstitucionVisa() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EventosInstitucionVisa> buscarPorInstEventosInstitucionVisa(Integer idInstitucion){
		return this.eventosInstitucionVisaMapper.buscarPorInst(idInstitucion); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EventosInstitucionVisa> registrarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa) {
		System.out.println(eventosInstitucionVisa);
		this.registrar(eventosInstitucionVisa);
		return this.eventosInstitucionVisaMapper.buscarPorInst(eventosInstitucionVisa.getIdInstitucion()); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EventosInstitucionVisa> actualizarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa) {
		System.out.println(eventosInstitucionVisa);
		this.registrar(eventosInstitucionVisa);
		return this.eventosInstitucionVisaMapper.buscarPorInst(eventosInstitucionVisa.getIdInstitucion());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa) {
		this.eliminar(eventosInstitucionVisa);
		
	}
}
