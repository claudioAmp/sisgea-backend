package edu.taller.sisgea.mantenimientosgenerales.service.instituciontransaccion;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IInstitucionTransaccionMapper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.InstitucionTransaccion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstitucionTransaccionService extends MantenibleService<InstitucionTransaccion>
		implements IInstitucionTransaccionService {
	
	private static final String INSTITUCION_TRANSACCION_NO_ENCONTRADO =
			"No existe la asociación entre la institución %s, la clase de transaccion %s y el código de transacción " +
			"%s";
	private final IInstitucionTransaccionMapper institucionesTransaccionMapper;
	
	public InstitucionTransaccionService(
			@Qualifier("IInstitucionTransaccionMapper") IMantenibleMapper<InstitucionTransaccion> mantenibleMapper) {
		super(mantenibleMapper);
		this.institucionesTransaccionMapper = (IInstitucionTransaccionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public InstitucionTransaccion registrarInstitucionTransaccion(int idInstitucion,
	                                                              InstitucionTransaccion institucionTransaccion) {
		institucionTransaccion.setIdInstitucion(idInstitucion);
		this.registrar(institucionTransaccion);
		return this.buscarInstitucionTransaccion(institucionTransaccion.getIdInstitucion(),
		                                         institucionTransaccion.getIdClaseTransaccion(),
		                                         institucionTransaccion.getIdCodigoTransaccion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarInstitucionTransaccion(int idInstitucion, int idClaseTransaccion, int idCodigoTransaccion) {
		InstitucionTransaccion institucionTransaccion = InstitucionTransaccion.builder().idInstitucion(idInstitucion)
		                                                                      .idClaseTransaccion(idClaseTransaccion)
		                                                                      .idCodigoTransaccion(idCodigoTransaccion)
		                                                                      .build();
		this.eliminar(institucionTransaccion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<InstitucionTransaccion> buscarTodosInstitucionesTransacciones() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public InstitucionTransaccion buscarInstitucionTransaccion(int idInstitucion, int idClaseTransaccion,
	                                                           int idCodigoTransaccion) {
		return this.institucionesTransaccionMapper.buscarInstitucionTransaccion(idInstitucion, idClaseTransaccion,
		                                                                        idCodigoTransaccion).orElseThrow(
				() -> new RecursoNoEncontradoException(INSTITUCION_TRANSACCION_NO_ENCONTRADO, idInstitucion,
				                                       idClaseTransaccion, idCodigoTransaccion));
	}
}
