package ob.unibanca.sicf.conciliacion.service.conciliacion;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.conciliacion.mapper.IConciliacionMapper;
import ob.unibanca.sicf.conciliacion.model.Conciliacion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConciliacionService extends MantenibleService<Conciliacion> implements IConciliacionService {
	
	private static final String CONCILIACION_NO_ENCONTRADO = "No existe la asociación entre la conciliación %s y el paquete %s";
	private final IConciliacionMapper conciliacionMapper;
	
	public ConciliacionService(@Qualifier("IConciliacionMapper") IMantenibleMapper<Conciliacion> mantenibleMapper) {
		super(mantenibleMapper);
		this.conciliacionMapper = (IConciliacionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Conciliacion> buscarTodosConciliaciones() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Conciliacion buscarConciliacion(Integer idConciliacion,Integer idPaquete) {
		return this.conciliacionMapper.buscarConciliacion(idConciliacion,idPaquete).orElseThrow(
				() -> new RecursoNoEncontradoException(CONCILIACION_NO_ENCONTRADO, idConciliacion, idPaquete));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Conciliacion> buscarConciliacionPorPaquete(Integer idPaquete) {
		return this.conciliacionMapper.buscarConciliacionPorPaquete(idPaquete);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Conciliacion registrarConciliacion(Integer idPaquete,Conciliacion conciliacion) {
		this.registrar(conciliacion);
		return this.buscarConciliacion(conciliacion.getIdConciliacion(),conciliacion.getIdPaquete());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Conciliacion actualizarConciliacion(Integer idConciliacion,Integer idPaquete,Conciliacion conciliacion) {
		conciliacion.setIdConciliacion(idConciliacion);
		conciliacion.setIdPaquete(idPaquete);
		this.actualizar(conciliacion);
		return this.buscarConciliacion(conciliacion.getIdConciliacion(),conciliacion.getIdPaquete());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarConciliacion(Integer idConciliacion,Integer idPaquete) {
		Conciliacion conciliacion = Conciliacion.builder().idConciliacion(idConciliacion).idPaquete(idPaquete).build();
		this.eliminar(conciliacion);
	}
	
}
