package ob.unibanca.sicf.mantenimientosgenerales.service.moneda;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Moneda;

import java.util.List;

public interface IMonedaService extends IMantenibleService<Moneda> {
	
	List<Moneda> buscarTodosMonedas();
	
}
