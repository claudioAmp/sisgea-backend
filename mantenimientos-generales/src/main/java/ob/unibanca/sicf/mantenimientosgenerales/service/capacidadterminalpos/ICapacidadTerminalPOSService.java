package ob.unibanca.sicf.mantenimientosgenerales.service.capacidadterminalpos;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CapacidadTerminalPOS;

import java.util.List;

public interface ICapacidadTerminalPOSService extends IMantenibleService<CapacidadTerminalPOS> {
	
	List<CapacidadTerminalPOS> buscarTodosCapacidadTerminalPOS();
	
	List<CapacidadTerminalPOS> buscarCapacidadTerminalPOSPorMembresia(String idMembresia);
	
	CapacidadTerminalPOS buscarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS);
	
	CapacidadTerminalPOS registrarCapacidadTerminalPOS(String idMembresia, CapacidadTerminalPOS capacidadTerminalPOS);
	
	CapacidadTerminalPOS actualizarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS, CapacidadTerminalPOS capacidadTerminalPOS);
	
	void eliminarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS);
}