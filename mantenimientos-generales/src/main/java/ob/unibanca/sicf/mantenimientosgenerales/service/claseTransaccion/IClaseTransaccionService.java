package ob.unibanca.sicf.mantenimientosgenerales.service.claseTransaccion;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ClaseTransaccion;

public interface IClaseTransaccionService extends IMantenibleService<ClaseTransaccion> {

	List<ClaseTransaccion> buscarTodosClaseTransacciones();
	
	ClaseTransaccion registrarClaseTransaccion(ClaseTransaccion claseTransaccion);
	
	ClaseTransaccion actualizarClaseTransaccion(int idClaseTransaccion, ClaseTransaccion claseTransaccion);
	
	void eliminarClaseTransaccion(int idClaseTransaccion);
	
}
