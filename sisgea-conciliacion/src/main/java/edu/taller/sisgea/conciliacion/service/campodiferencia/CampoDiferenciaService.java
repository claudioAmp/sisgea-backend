package edu.taller.sisgea.conciliacion.service.campodiferencia;

import edu.taller.sisgea.conciliacion.model.CampoDiferencia;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.conciliacion.mapper.ICampoDiferenciaMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampoDiferenciaService extends MantenibleService<CampoDiferencia> implements ICampoDiferenciaService {
	
	private static final String CAMPO_DIFERENCIA_NO_ENCONTRADO = "No existe la asociación entre el campo diferencia %s y la tabla de conciliación %s";
	private final ICampoDiferenciaMapper campoDiferenciaMapper;
	
	public CampoDiferenciaService(@Qualifier("ICampoDiferenciaMapper") IMantenibleMapper<CampoDiferencia> mantenibleMapper) {
		super(mantenibleMapper);
		this.campoDiferenciaMapper = (ICampoDiferenciaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoDiferencia> buscarTodosCampoDiferencias() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CampoDiferencia buscarCampoDiferencia(Integer idCampoDiferencia,Integer idConcTabla) {
		return this.campoDiferenciaMapper.buscarCampoDiferencia(idCampoDiferencia, idConcTabla).orElseThrow(
				() -> new RecursoNoEncontradoException(CAMPO_DIFERENCIA_NO_ENCONTRADO, idCampoDiferencia, idConcTabla));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CampoDiferencia> buscarCampoDiferenciaPorConciliacionTablas(Integer idConcTabla) {
		return this.campoDiferenciaMapper.buscarCampoDiferenciaPorConciliacionTablas(idConcTabla);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoDiferencia registrarCampoDiferencia(Integer idConcTabla, CampoDiferencia campoDiferencia) {
		this.registrar(campoDiferencia);
		return this.buscarCampoDiferencia(campoDiferencia.getIdCampoDiferencia(), campoDiferencia.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CampoDiferencia actualizarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla, CampoDiferencia campoDiferencia) {
		campoDiferencia.setIdCampoDiferencia(idCampoDiferencia);
		campoDiferencia.setIdConcTabla(idConcTabla);
		this.actualizar(campoDiferencia);
		return this.buscarCampoDiferencia(campoDiferencia.getIdCampoDiferencia(), campoDiferencia.getIdConcTabla());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla) {
		CampoDiferencia campoDiferencia = CampoDiferencia.builder().idCampoDiferencia(idCampoDiferencia).idConcTabla(idConcTabla).build();
		this.eliminar(campoDiferencia);
	}
	
}
