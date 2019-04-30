package ob.unibanca.sicf.mantenimientosgenerales.service.respuestamarcaint;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.RespuestaMarcaInt;

import java.util.List;

public interface IRespuestaMarcaIntService extends IMantenibleService<RespuestaMarcaInt> {
	
	List<RespuestaMarcaInt> buscarTodosRespuestasMarcasInt();
	
	List<RespuestaMarcaInt> buscarRespuestasMarcasIntPorMembresia(String idMembresia);
	
	RespuestaMarcaInt buscarRespuestaMarcaInt(String idMembresia, String idRespuesta);
	
	RespuestaMarcaInt registrarRespuestaMarcaInt(String idMembresia, RespuestaMarcaInt respuestaMarcaInt);
	
	RespuestaMarcaInt actualizarRespuestaMarcaInt(String idMembresia, String idRespuesta, RespuestaMarcaInt respuestaMarcaInt);
	
	void eliminarRespuestaMarcaInt(String idMembresia, String idRespuesta);
}