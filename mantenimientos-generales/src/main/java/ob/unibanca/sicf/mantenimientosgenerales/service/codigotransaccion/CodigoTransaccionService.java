package ob.unibanca.sicf.mantenimientosgenerales.service.codigotransaccion;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.ICodigoTransaccionMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoTransaccion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoTransaccionService extends MantenibleService<CodigoTransaccion>
		implements ICodigoTransaccionService {
	
	private static final String CODIGO_TRANSACCION_NO_ENCONTRADO = "El Código transacción %d asociado a la Clase " +
	                                                               "transacción %d no fue encontrado";
	
	private final ICodigoTransaccionMapper codigoTransaccionMapper;
	
	public CodigoTransaccionService(
			@Qualifier("ICodigoTransaccionMapper") IMantenibleMapper<CodigoTransaccion> mantenibleMapper) {
		super(mantenibleMapper);
		this.codigoTransaccionMapper = (ICodigoTransaccionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CodigoTransaccion> buscarCodigosTransaccionClaseTransaccion(int idClaseTransaccion) {
		return this.codigoTransaccionMapper.buscarCodigosTransaccionClaseTransaccion(idClaseTransaccion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoTransaccion registrarCodigoTransaccion(int idClaseTransaccion, CodigoTransaccion codigoTransaccion) {
		codigoTransaccion.setIdClaseTransaccion(idClaseTransaccion);
		super.registrar(codigoTransaccion);
		return this.buscarCodigoTransaccion(codigoTransaccion.getIdClaseTransaccion(),
		                                    codigoTransaccion.getIdCodigoTransaccion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoTransaccion actualizarCodigoTransaccion(int idClaseTransaccion, int idCodigoTransaccion,
	                                                     CodigoTransaccion codigoTransaccion) {
		codigoTransaccion.setIdClaseTransaccion(idClaseTransaccion);
		codigoTransaccion.setIdCodigoTransaccion(idCodigoTransaccion);
		super.actualizar(codigoTransaccion);
		return this.buscarCodigoTransaccion(codigoTransaccion.getIdClaseTransaccion(),
		                                    codigoTransaccion.getIdCodigoTransaccion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCodigoTransaccion(int idClaseTransaccion, int idCodigoTransaccion) {
		CodigoTransaccion codigoTransaccion = CodigoTransaccion.builder().idClaseTransaccion(idClaseTransaccion)
		                                                       .idCodigoTransaccion(idCodigoTransaccion).build();
		super.eliminar(codigoTransaccion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CodigoTransaccion> buscarTodosCodigoTransacciones() {
		return super.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CodigoTransaccion buscarCodigoTransaccion(int idClaseTransaccion, int idCodigoTransaccion) {
		return this.codigoTransaccionMapper.buscarUno(idClaseTransaccion, idCodigoTransaccion).orElseThrow(
				() -> new RecursoNoEncontradoException(CODIGO_TRANSACCION_NO_ENCONTRADO, idClaseTransaccion,
				                                       idCodigoTransaccion));
	}
}
