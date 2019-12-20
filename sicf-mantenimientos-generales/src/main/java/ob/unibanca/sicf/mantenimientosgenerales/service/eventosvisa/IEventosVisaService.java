package ob.unibanca.sicf.mantenimientosgenerales.service.eventosvisa;

import java.util.List;

import ob.unibanca.sicf.mantenimientosgenerales.model.EventosVisa;

public interface IEventosVisaService {
	
	public List<EventosVisa> buscarTodosEventosVisa();
	public List<EventosVisa> buscaridDescripcionEventosVisa();

}
