package ob.unibanca.sicf.mantenimientosgenerales.service.clasetransaccion;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ClaseTransaccion;

import java.util.List;

public interface IClaseTransaccionService extends IMantenibleService<ClaseTransaccion> {

	List<ClaseTransaccion> buscarTodosClaseTransacciones();
	
	ClaseTransaccion registrarClaseTransaccion(ClaseTransaccion claseTransaccion);
	
	ClaseTransaccion actualizarClaseTransaccion(int idClaseTransaccion, ClaseTransaccion claseTransaccion);
	
	void eliminarClaseTransaccion(int idClaseTransaccion);
	
}
