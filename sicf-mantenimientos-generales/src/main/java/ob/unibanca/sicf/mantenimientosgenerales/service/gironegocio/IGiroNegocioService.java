package ob.unibanca.sicf.mantenimientosgenerales.service.gironegocio;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.GiroNegocio;

public interface IGiroNegocioService extends IMantenibleService<GiroNegocio> {
	
	List<GiroNegocio> buscarTodosGiroNegocioPOS();
	
	List<GiroNegocio> buscarGiroNegocioPorMembresia(String idMembresia);
}
