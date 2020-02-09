package edu.taller.sisgea.mantenimientosgenerales.service.clasetransaccion;

import edu.taller.sisgea.mantenimientosgenerales.model.ClaseTransaccion;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IClaseTransaccionService extends IMantenibleService<ClaseTransaccion> {

	List<ClaseTransaccion> buscarTodosClaseTransacciones();
	
	ClaseTransaccion registrarClaseTransaccion(ClaseTransaccion claseTransaccion);
	
	ClaseTransaccion actualizarClaseTransaccion(int idClaseTransaccion, ClaseTransaccion claseTransaccion);
	
	void eliminarClaseTransaccion(int idClaseTransaccion);
	
}
