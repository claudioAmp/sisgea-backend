package edu.taller.sisgea.tarifarios.service.esquematarifario;

import java.util.List;

import edu.taller.sisgea.tarifarios.model.EsquemaTarifario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.tarifarios.mapper.IEsquemaTarifarioMapper;

@Service
public class EsquemaTarifarioService extends MantenibleService<EsquemaTarifario> implements IEsquemaTarifarioService{
	
	private static final String ESQUEMA_NO_ENCONTRADO = "El esquema tarifario no existe";
	private final IEsquemaTarifarioMapper esquemaTarifarioMapper;
	
	public EsquemaTarifarioService(@Qualifier("IEsquemaTarifarioMapper") IMantenibleMapper<EsquemaTarifario> mantenibleMapper) {
		super(mantenibleMapper);
		this.esquemaTarifarioMapper = (IEsquemaTarifarioMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EsquemaTarifario> buscarTodosEsquemas(){
	return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EsquemaTarifario registrarEsquema(EsquemaTarifario esquemaTarifario) {
		this.registrar(esquemaTarifario);
		return this.buscarEsquemaTarifario(esquemaTarifario.getIdEsquema());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EsquemaTarifario actualizarEsquema(int idEsquema, EsquemaTarifario esquemaTarifario) {
		esquemaTarifario.setIdEsquema(idEsquema);
		this.actualizar(esquemaTarifario);
		return this.buscarEsquemaTarifario(esquemaTarifario.getIdEsquema());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarEsquema(int idEsquema) {
		EsquemaTarifario esquemaTarifario = EsquemaTarifario.builder().idEsquema(idEsquema).build();
		this.eliminar(esquemaTarifario);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EsquemaTarifario buscarEsquemaTarifario(int idEsquema) {
		return this.esquemaTarifarioMapper.buscarEsquemaTarifario(idEsquema).orElseThrow(
				() -> new RecursoNoEncontradoException(ESQUEMA_NO_ENCONTRADO, idEsquema));
	}

}
