package ob.unibanca.sicf.mantenimientosgenerales.service.eventosinstitucionmastercard;

import java.util.List;
import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosInstitucionMastercard;

public interface IEventosInstitucionMastercardService extends IMantenibleService<EventosInstitucionMastercard>{
	
	List<EventosInstitucionMastercard> buscarTodosEventosInstitucionMastercard();
	
	List<EventosInstitucionMastercard> buscarPorInstEventosInstitucionMastercard(Integer idInstitucion);
	
	List<EventosInstitucionMastercard> registrarEventosInstitucionMastercard(EventosInstitucionMastercard eventosInstitucionMastercard);
	
	List<EventosInstitucionMastercard> actualizarEventosInstitucionMastercard(EventosInstitucionMastercard eventosInstitucionMastercard);
	
	void eliminarEventosInstitucionMastercard(EventosInstitucionMastercard eventosInstitucionMastercard);
}
