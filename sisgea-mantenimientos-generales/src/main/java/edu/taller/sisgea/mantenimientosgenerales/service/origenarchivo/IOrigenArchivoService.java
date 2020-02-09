package edu.taller.sisgea.mantenimientosgenerales.service.origenarchivo;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.OrigenArchivo;

import java.util.List;

public interface IOrigenArchivoService extends IMantenibleService<OrigenArchivo> {
	
	List<OrigenArchivo> buscarTodosOrigenArchivo();
	
	List<OrigenArchivo> buscarOrigenArchivoPorConciliacion(boolean concilia);
	
	OrigenArchivo buscarOrigenArchivo(String idOrigenArchivo);
	
	OrigenArchivo registrarOrigenArchivo(OrigenArchivo origenArchivo);
	
	OrigenArchivo actualizarOrigenArchivo(String idOrigenArchivo, OrigenArchivo origenARchivo);
	
	void eliminarOrigenArchivo(String idOrigenArchivo);
	
}