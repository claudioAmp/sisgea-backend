package ob.unibanca.sicf.mantenimientosgenerales.service.eventosinstitucionvisa;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IEventosInstitucionVisaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IInstitucionMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosInstitucionVisa;
import ob.unibanca.sicf.mantenimientosgenerales.service.eventosinstitucionvisa.IEventosInstitucionVisaService;

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
	public EventosInstitucionVisa registrarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa) {
		this.registrar(eventosInstitucionVisa);
		return this.buscarUno(eventosInstitucionVisa).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EventosInstitucionVisa actualizarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa) {
		this.actualizar(eventosInstitucionVisa);
		return this.buscarUno(eventosInstitucionVisa).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa) {
		this.eliminar(eventosInstitucionVisa);
		
	}
}
