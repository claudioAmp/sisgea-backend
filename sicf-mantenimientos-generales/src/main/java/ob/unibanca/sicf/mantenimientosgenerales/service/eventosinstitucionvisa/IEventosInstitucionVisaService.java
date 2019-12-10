package ob.unibanca.sicf.mantenimientosgenerales.service.eventosinstitucionvisa;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosInstitucionVisa;

public interface IEventosInstitucionVisaService extends IMantenibleService<EventosInstitucionVisa>{
	
	List<EventosInstitucionVisa> buscarTodosEventosInstitucionVisa();
	
	List<EventosInstitucionVisa> buscarPorInstEventosInstitucionVisa(Integer idInstitucion);
	
	List<EventosInstitucionVisa> registrarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
	
	List<EventosInstitucionVisa> actualizarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
	
	void eliminarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
}
