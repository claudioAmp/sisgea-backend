package edu.taller.sisgea.mantenimientosgenerales.service.correotelefono;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.CorreoTelefono;

import java.util.List;

public interface ICorreoTelefonoService extends IMantenibleService<CorreoTelefono> {
	
	List<CorreoTelefono> buscarTodosCorreosTelefonos();
	
	List<CorreoTelefono> buscarCorreosTelefonosPorMembresia(String idCorreoTelefono);
	
	CorreoTelefono buscarCorreoTelefono(String idMembresia, String idCorreoTelefono);
	
	CorreoTelefono registrarCorreoTelefono(String idMembresia, CorreoTelefono correoTelefono);
	
	CorreoTelefono actualizarCorreoTelefono(String idMembresia, String idCorreoTelefono, CorreoTelefono correoTelefono);
	
	void eliminarCorreoTelefono(String idMembresia, String idCorreoTelefono);
	
}