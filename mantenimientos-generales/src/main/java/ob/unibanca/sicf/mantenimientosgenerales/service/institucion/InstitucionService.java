package ob.unibanca.sicf.mantenimientosgenerales.service.institucion;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IInstitucionMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.Institucion;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstitucionService extends MantenibleService<Institucion> implements IInstitucionService {
	
	private static final String INSTITUCION_NO_ENCONTRADO = "La institución %s no existe";
	private final IInstitucionMapper institucionMapper;
	
	public InstitucionService(@Qualifier("IInstitucionMapper") IMantenibleMapper<Institucion> mantenibleMapper) {
		super(mantenibleMapper);
		this.institucionMapper = (IInstitucionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Institucion registrarInstitucion(Institucion institucion) {
		this.registrar(institucion);
		return this.buscarInstitucion(institucion.getIdInstitucion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Institucion actualizarInstitucion(int idInstitucion, Institucion institucion) {
		institucion.setIdInstitucion(idInstitucion);
		this.actualizar(institucion);
		return this.buscarInstitucion(institucion.getIdInstitucion());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarInstitucion(int idInstitucion) {
		Institucion institucion = Institucion.builder().idInstitucion(idInstitucion).build();
		this.eliminar(institucion);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Institucion> buscarTodosInstituciones() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Institucion buscarInstitucion(int idInstitucion) {
		return this.institucionMapper.buscarInstitucion(idInstitucion).orElseThrow(
				() -> new RecursoNoEncontradoException(INSTITUCION_NO_ENCONTRADO, idInstitucion));
	}
}
