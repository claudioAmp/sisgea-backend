package ob.unibanca.sicf.mantenimientosgenerales.service.eventostransaccionvisa;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.EventosTransaccionVisa;

public interface IEventosTransaccionVisaService extends IMantenibleService<EventosTransaccionVisa> {
	
	List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisaes();
	
	EventosTransaccionVisa registrarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa);
	
	EventosTransaccionVisa actualizarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa);
	
	void eliminarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa);
}
