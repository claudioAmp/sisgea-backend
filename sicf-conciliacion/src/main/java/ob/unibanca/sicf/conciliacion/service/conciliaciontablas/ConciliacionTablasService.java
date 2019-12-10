package ob.unibanca.sicf.conciliacion.service.conciliaciontablas;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.conciliacion.mapper.IConciliacionTablasMapper;
import ob.unibanca.sicf.conciliacion.model.ConciliacionTablas;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConciliacionTablasService extends MantenibleService<ConciliacionTablas> implements IConciliacionTablasService {
	
	private static final String CONCILIACION_TABLAS_NO_ENCONTRADO = "No existe la asociación entre las tablas de conciliación %s y el procedimiento de conciliación %s";
	private final IConciliacionTablasMapper conciliacionTablasMapper;
	
	public ConciliacionTablasService(@Qualifier("IConciliacionTablasMapper") IMantenibleMapper<ConciliacionTablas> mantenibleMapper) {
		super(mantenibleMapper);
		this.conciliacionTablasMapper = (IConciliacionTablasMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ConciliacionTablas> buscarTodosConciliacionTablas() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ConciliacionTablas buscarConciliacionTablas(Integer idConcTabla,Integer idConciliacion) {
		return this.conciliacionTablasMapper.buscarConciliacionTablas(idConcTabla,idConciliacion).orElseThrow(
				() -> new RecursoNoEncontradoException(CONCILIACION_TABLAS_NO_ENCONTRADO, idConcTabla, idConciliacion));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ConciliacionTablas> buscarConciliacionTablasPorConciliacion(Integer idConciliacion) {
		return this.conciliacionTablasMapper.buscarConciliacionTablasPorConciliacion(idConciliacion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ConciliacionTablas registrarConciliacionTablas(Integer idConciliacion,ConciliacionTablas conciliacionTablas) {
		this.registrar(conciliacionTablas);
		return this.buscarConciliacionTablas(conciliacionTablas.getIdConcTabla(),conciliacionTablas.getIdConciliacion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ConciliacionTablas actualizarConciliacionTablas(Integer idConcTabla,Integer idConciliacion,ConciliacionTablas conciliacionTablas) {
		conciliacionTablas.setIdConcTabla(idConcTabla);
		conciliacionTablas.setIdConciliacion(idConciliacion);
		this.actualizar(conciliacionTablas);
		return this.buscarConciliacionTablas(conciliacionTablas.getIdConcTabla(),conciliacionTablas.getIdConciliacion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarConciliacionTablas(Integer idConcTabla,Integer idConciliacion) {
		ConciliacionTablas conciliacionTablas = ConciliacionTablas.builder().idConcTabla(idConcTabla).idConciliacion(idConciliacion).build();
		this.eliminar(conciliacionTablas);
	}
	
}
