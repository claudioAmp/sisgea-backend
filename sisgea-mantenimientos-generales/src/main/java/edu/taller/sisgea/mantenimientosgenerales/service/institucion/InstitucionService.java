package edu.taller.sisgea.mantenimientosgenerales.service.institucion;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IInstitucionMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.Institucion;
import edu.taller.sisgea.mantenimientosgenerales.model.criterio.CriterioBusquedaInstitucion;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;

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
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Institucion> buscarPorCriterios(CriterioBusquedaInstitucion criterio) {
		return this.institucionMapper.buscarPorCriterios(criterio);
	}
}
