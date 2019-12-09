package ob.unibanca.sicf.mantenimientosgenerales.service.eventosinstitucionvisa;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosInstitucionVisa;

public interface IEventosInstitucionVisaService extends IMantenibleService<EventosInstitucionVisa>{
	
	List<EventosInstitucionVisa> buscarTodosEventosInstitucionVisa();
	
	EventosInstitucionVisa registrarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
	
	EventosInstitucionVisa actualizarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
	
	void eliminarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
}
