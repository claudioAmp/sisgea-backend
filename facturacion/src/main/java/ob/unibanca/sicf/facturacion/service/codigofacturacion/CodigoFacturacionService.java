package ob.unibanca.sicf.facturacion.service.codigofacturacion;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.facturacion.mapper.ICodigoFacturacionMapper;
import ob.unibanca.sicf.facturacion.model.CodigoFacturacion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoFacturacionService extends MantenibleService<CodigoFacturacion>
		implements ICodigoFacturacionService {
	
	private static final String CODIGO_FACTURACION_NO_ENCONTRADO = "El código de facturación %s no fue encontrado";
	private final ICodigoFacturacionMapper codigoFacturacionMapper;
	
	public CodigoFacturacionService(
			@Qualifier("ICodigoFacturacionMapper") IMantenibleMapper<CodigoFacturacion> mantenibleMapper) {
		super(mantenibleMapper);
		this.codigoFacturacionMapper = (ICodigoFacturacionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoFacturacion registrarCodigoFacturacion(CodigoFacturacion codigoFacturacion) {
		this.registrar(codigoFacturacion);
		return this.buscarCodigoFacturacion(codigoFacturacion.getIdCodigoFacturacion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoFacturacion actualizarCodigoFacturacion(int idCodigoFacturacion,
	                                                     CodigoFacturacion codigoFacturacion) {
		codigoFacturacion.setIdCodigoFacturacion(idCodigoFacturacion);
		this.actualizar(codigoFacturacion);
		return this.buscarCodigoFacturacion(codigoFacturacion.getIdCodigoFacturacion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCodigoFacturacion(int idCodigoFacturacion) {
		CodigoFacturacion codigoFacturacion = CodigoFacturacion.builder().idCodigoFacturacion(idCodigoFacturacion)
		                                                       .build();
		this.eliminar(codigoFacturacion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CodigoFacturacion> buscarTodosCodigosFacturaciones() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CodigoFacturacion buscarCodigoFacturacion(int idCodigoFacturacion) {
		return this.codigoFacturacionMapper.buscarUno(idCodigoFacturacion).orElseThrow(
				() -> new RecursoNoEncontradoException(CODIGO_FACTURACION_NO_ENCONTRADO, idCodigoFacturacion));
	}
}
