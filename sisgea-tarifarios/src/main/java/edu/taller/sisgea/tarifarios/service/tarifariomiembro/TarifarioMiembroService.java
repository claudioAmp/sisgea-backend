package edu.taller.sisgea.tarifarios.service.tarifariomiembro;

import edu.taller.sisgea.tarifarios.model.TarifarioMiembro;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.tarifarios.mapper.ITarifarioMiembroMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TarifarioMiembroService extends MantenibleService<TarifarioMiembro> implements ITarifarioMiembroService{

	private static  final String TARIFARIO_MIEMBRO_NO_ENCONTRADO = "El Tarifario Miembro %s no existe";
	private final ITarifarioMiembroMapper tarifarioMiembroMapper;
	
	public TarifarioMiembroService(@Qualifier("ITarifarioMiembroMapper") IMantenibleMapper<TarifarioMiembro> mantenibleMapper) {
		super(mantenibleMapper);
		this.tarifarioMiembroMapper = (ITarifarioMiembroMapper) mantenibleMapper;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TarifarioMiembro> buscarTodosTarifariosMiembros() {
		return this.buscarTodos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TarifarioMiembro buscarTarifarioMiembro(Integer idTarifarioMiembro) {
		return this.tarifarioMiembroMapper.buscarTarifarioMiembro(idTarifarioMiembro).orElseThrow(
				() -> new RecursoNoEncontradoException(TARIFARIO_MIEMBRO_NO_ENCONTRADO, idTarifarioMiembro));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioMiembro registrarTarifarioMiembro(TarifarioMiembro tarifarioMiembro) {
		this.registrar(tarifarioMiembro);
		return this.buscarTarifarioMiembro(tarifarioMiembro.getIdTarifarioMiembro());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioMiembro actualizarTarifarioMiembro(Integer idTarifarioMiembro, TarifarioMiembro tarifarioMiembro) {
		tarifarioMiembro.setIdTarifarioMiembro(idTarifarioMiembro);
	    this.actualizar(tarifarioMiembro);
		return this.buscarTarifarioMiembro(tarifarioMiembro.getIdTarifarioMiembro());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTarifarioMiembro(Integer idTarifarioMiembro) {
		TarifarioMiembro tarifarioMiembro = TarifarioMiembro.builder().idTarifarioMiembro(idTarifarioMiembro).build();
		this.eliminar(tarifarioMiembro);
	}

}
