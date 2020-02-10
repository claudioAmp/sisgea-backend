package edu.taller.sisgea.mantenimientosgenerales.service.programacion;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IProgramacionMapper;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.Programacion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProgramacionService extends MantenibleService<Programacion> implements IProgramacionService {
	
	private static final String PROGRAMACION_NO_ENCONTRADO = "La programación del Curso %s , Sección %d no existe";
	private final IProgramacionMapper programacionMapper;
	
	public ProgramacionService(@Qualifier("IProgramacionMapper") IMantenibleMapper<Programacion> mantenibleMapper) {
		super(mantenibleMapper);
		this.programacionMapper = (IProgramacionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Programacion> buscarTodosProgramacion() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Programacion buscarProgramacion(String idCurso, Integer seccion) {
		return this.programacionMapper.buscarProgramacion(idCurso, seccion).orElseThrow(
				() -> new RecursoNoEncontradoException(PROGRAMACION_NO_ENCONTRADO, idCurso, seccion));
	}
	
}
