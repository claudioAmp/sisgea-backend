package ob.unibanca.sicf.mantenimientosgenerales.service.canal;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Canal;

import java.util.List;

public interface ICanalService extends IMantenibleService<Canal> {
	
	List<Canal> buscarTodosCanales();
	
	Canal registrarCanal(Canal canal);
	
	Canal actualizarCanal(int idCanal, Canal canal);
	
	void eliminarCanal(int idCanal);
	
}
