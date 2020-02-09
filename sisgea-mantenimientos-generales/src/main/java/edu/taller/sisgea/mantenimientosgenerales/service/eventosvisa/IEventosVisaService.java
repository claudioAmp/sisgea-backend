package edu.taller.sisgea.mantenimientosgenerales.service.eventosvisa;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.EventosVisa;

public interface IEventosVisaService {
	
	public List<EventosVisa> buscarTodosEventosVisa();
	public List<EventosVisa> buscaridDescripcionEventosVisa();
	
	public List<EventosVisa> buscarTodosEventosTransaccionVisaSinTxn();

}
