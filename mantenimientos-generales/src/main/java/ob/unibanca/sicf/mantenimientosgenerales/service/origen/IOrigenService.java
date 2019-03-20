package ob.unibanca.sicf.mantenimientosgenerales.service.origen;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Origen;

import java.util.List;

public interface IOrigenService extends IMantenibleService<Origen> {
	
	List<Origen> buscarTodosOrigenes();
	
	Origen buscarOrigen(int idOrigen);
	
	Origen registrarOrigen(Origen origen);
	
	Origen actualizarOrigen(int idOrigen, Origen origen);
	
	void eliminarOrigen(int idOrigen);
}
