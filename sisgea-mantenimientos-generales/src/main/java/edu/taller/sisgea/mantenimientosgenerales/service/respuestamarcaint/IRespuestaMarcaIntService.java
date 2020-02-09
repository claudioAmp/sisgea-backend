package edu.taller.sisgea.mantenimientosgenerales.service.respuestamarcaint;

import edu.taller.sisgea.mantenimientosgenerales.model.RespuestaMarcaInt;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface IRespuestaMarcaIntService extends IMantenibleService<RespuestaMarcaInt> {
	
	List<RespuestaMarcaInt> buscarTodosRespuestasMarcasInt();
	
	List<RespuestaMarcaInt> buscarRespuestasMarcasIntPorMembresia(String idMembresia);
	
	RespuestaMarcaInt buscarRespuestaMarcaInt(String idMembresia, String idRespuesta);
	
	RespuestaMarcaInt registrarRespuestaMarcaInt(String idMembresia, RespuestaMarcaInt respuestaMarcaInt);
	
	RespuestaMarcaInt actualizarRespuestaMarcaInt(String idMembresia, String idRespuesta, RespuestaMarcaInt respuestaMarcaInt);
	
	void eliminarRespuestaMarcaInt(String idMembresia, String idRespuesta);
}