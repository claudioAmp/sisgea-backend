package edu.taller.sisgea.mantenimientosgenerales.service.eventosinstitucionvisa;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.EventosInstitucionVisa;

import ob.commons.mantenimiento.service.IMantenibleService;

public interface IEventosInstitucionVisaService extends IMantenibleService<EventosInstitucionVisa>{
	
	List<EventosInstitucionVisa> buscarTodosEventosInstitucionVisa();
	
	List<EventosInstitucionVisa> buscarPorInstEventosInstitucionVisa(Integer idInstitucion);
	
	List<EventosInstitucionVisa> registrarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
	
	List<EventosInstitucionVisa> actualizarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
	
	void eliminarEventosInstitucionVisa(EventosInstitucionVisa eventosInstitucionVisa);
}
