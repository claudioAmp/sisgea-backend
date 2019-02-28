package ob.unibanca.sicf.mantenimientosgenerales.service.membresia;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.Membresia;

import java.util.List;

public interface IMembresiaService extends IMantenibleService<Membresia> {
	
	List<Membresia> buscarTodosMembresias();
	
	Membresia registrarMembresia(Membresia membresia);
	
	Membresia actualizarMembresia(String idMembresia, Membresia membresia);
	
	void eliminarMembresia(String idMembresia);
}
