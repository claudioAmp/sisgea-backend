package edu.taller.sisgea.mantenimientosgenerales.service.capacidadterminalpos;

import edu.taller.sisgea.mantenimientosgenerales.model.CapacidadTerminalPOS;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ICapacidadTerminalPOSService extends IMantenibleService<CapacidadTerminalPOS> {
	
	List<CapacidadTerminalPOS> buscarTodosCapacidadesTerminalesPOS();
	
	List<CapacidadTerminalPOS> buscarCapacidadesTerminalesPOSPorMembresia(String idMembresia);
	
	CapacidadTerminalPOS buscarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS);
	
	CapacidadTerminalPOS registrarCapacidadTerminalPOS(String idMembresia, CapacidadTerminalPOS capacidadTerminalPOS);
	
	CapacidadTerminalPOS actualizarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS, CapacidadTerminalPOS capacidadTerminalPOS);
	
	void eliminarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS);
	
}