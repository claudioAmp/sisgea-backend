package ob.unibanca.sicf.mantenimientosgenerales.service.respuestamarcaint;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IRespuestaMarcaIntMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.RespuestaMarcaInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespuestaMarcaIntService extends MantenibleService<RespuestaMarcaInt> implements IRespuestaMarcaIntService {
	
	private static final String RESPUESTA_MARCA_INT_NO_ENCONTRADO =
			"No existe asociación entre la respuesta %s y la membresía %s";
	private final IRespuestaMarcaIntMapper respuestaMarcaIntMapper;
	
	public RespuestaMarcaIntService(@Qualifier("IRespuestaMarcaIntMapper") IMantenibleMapper<RespuestaMarcaInt> mantenibleMapper) {
		super(mantenibleMapper);
		this.respuestaMarcaIntMapper = (IRespuestaMarcaIntMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public RespuestaMarcaInt registrarRespuestaMarcaInt(String idMembresia, RespuestaMarcaInt respuestaMarcaInt) {
		respuestaMarcaInt.setIdMembresia(idMembresia);
		this.registrar(respuestaMarcaInt);
		return this.buscarRespuestaMarcaInt(respuestaMarcaInt.getIdMembresia(), respuestaMarcaInt.getIdRespuesta());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public RespuestaMarcaInt actualizarRespuestaMarcaInt(String idMembresia, String idRespuesta, RespuestaMarcaInt respuestaMarcaInt) {
		respuestaMarcaInt.setIdMembresia(idMembresia);
		respuestaMarcaInt.setIdRespuesta(idRespuesta);
		this.actualizar(respuestaMarcaInt);
		return this.buscarRespuestaMarcaInt(respuestaMarcaInt.getIdMembresia(), respuestaMarcaInt.getIdRespuesta());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarRespuestaMarcaInt(String idMembresia, String idRespuesta) {
		RespuestaMarcaInt respuestaMarcaInt = RespuestaMarcaInt.builder().idMembresia(idMembresia).idRespuesta(idRespuesta).build();
		this.eliminar(respuestaMarcaInt);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<RespuestaMarcaInt> buscarTodosRespuestasMarcasInt() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public RespuestaMarcaInt buscarRespuestaMarcaInt(String idMembresia, String idRespuesta) {
		return this.respuestaMarcaIntMapper.buscarRespuestaMarcaInt(idMembresia, idRespuesta).orElseThrow(
				() -> new RecursoNoEncontradoException(RESPUESTA_MARCA_INT_NO_ENCONTRADO, idRespuesta, idMembresia));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<RespuestaMarcaInt> buscarRespuestasMarcasIntPorMembresia(String idMembresia) {
		return this.respuestaMarcaIntMapper.buscarRespuestasMarcasIntPorMembresia(idMembresia);
	}
}
