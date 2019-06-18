package ob.unibanca.sicf.tarifarios.service.tarifarioadquirente;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.tarifarios.mapper.ITarifarioAdquirenteMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioAdquirente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarifarioAdquirenteService extends MantenibleService<TarifarioAdquirente> implements ITarifarioAdquirenteService {
	
	private static final String TARIFARIO_ADQUIRENTE_NO_ENCONTRADO = "El Tarifario Adquirente %s no existe";
	private final ITarifarioAdquirenteMapper tarifarioAdquirenteMapper;
	
	public TarifarioAdquirenteService(@Qualifier("ITarifarioAdquirenteMapper") IMantenibleMapper<TarifarioAdquirente> mantenibleMapper) {
		super(mantenibleMapper);
		this.tarifarioAdquirenteMapper = (ITarifarioAdquirenteMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TarifarioAdquirente> buscarTodosTarifariosAdquirentes() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TarifarioAdquirente buscarTarifarioAdquirente(int idTarifarioAdquirente) {
		return this.tarifarioAdquirenteMapper.buscarTarifarioAdquirente(idTarifarioAdquirente).orElseThrow(
				() -> new RecursoNoEncontradoException(TARIFARIO_ADQUIRENTE_NO_ENCONTRADO, idTarifarioAdquirente));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioAdquirente registrarTarifarioAdquirente(TarifarioAdquirente tarifarioAdquirente) {
		this.registrar(tarifarioAdquirente);
		return this.buscarTarifarioAdquirente(tarifarioAdquirente.getIdTarifarioAdquirente());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioAdquirente actualizarTarifarioAdquirente(int idTarifarioAdquirente, TarifarioAdquirente tarifarioAdquirente) {
		tarifarioAdquirente.setIdTarifarioAdquirente(idTarifarioAdquirente);
		this.actualizar(tarifarioAdquirente);
		return this.buscarTarifarioAdquirente(tarifarioAdquirente.getIdTarifarioAdquirente());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTarifarioAdquirente(int idTarifarioAdquirente) {
		TarifarioAdquirente tarifarioAdquirente = TarifarioAdquirente.builder().idTarifarioAdquirente(idTarifarioAdquirente).build();
		this.eliminar(tarifarioAdquirente);
	}
	
}
