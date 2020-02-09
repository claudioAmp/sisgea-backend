package edu.taller.sisgea.mantenimientosgenerales.service.canal;

import edu.taller.sisgea.mantenimientosgenerales.model.Canal;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ICanalService extends IMantenibleService<Canal> {
	
	List<Canal> buscarTodosCanales();
	
	Canal registrarCanal(Canal canal);
	
	Canal actualizarCanal(int idCanal, Canal canal);
	
	void eliminarCanal(int idCanal);
	
}
