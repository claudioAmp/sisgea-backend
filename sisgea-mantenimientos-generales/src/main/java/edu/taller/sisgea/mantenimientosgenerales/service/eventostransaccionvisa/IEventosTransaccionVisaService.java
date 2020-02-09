package edu.taller.sisgea.mantenimientosgenerales.service.eventostransaccionvisa;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.EventosTransaccionVisa;

public interface IEventosTransaccionVisaService extends IMantenibleService<EventosTransaccionVisa> {
	
	List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisa();
	
	EventosTransaccionVisa registrarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa);
	
	EventosTransaccionVisa actualizarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa);
	
	void eliminarEventosTransaccionVisa(EventosTransaccionVisa eventosTransaccionVisa);
	
	public List<EventosTransaccionVisa> buscarTodosEventosTransaccionVisaSinTxn();
}
