package edu.taller.sisgea.mantenimientosgenerales.service.gironegocio;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.GiroNegocio;

public interface IGiroNegocioService extends IMantenibleService<GiroNegocio> {
	
	List<GiroNegocio> buscarTodosGiroNegocio();
	
	List<GiroNegocio> buscarGiroNegocioPorMembresia(String idMembresia);
}
