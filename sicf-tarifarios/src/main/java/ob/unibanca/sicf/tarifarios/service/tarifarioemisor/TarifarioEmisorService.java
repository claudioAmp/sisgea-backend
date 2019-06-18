package ob.unibanca.sicf.tarifarios.service.tarifarioemisor;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.tarifarios.mapper.ITarifarioEmisorMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioEmisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarifarioEmisorService extends MantenibleService<TarifarioEmisor> implements ITarifarioEmisorService {
	
	private static final String TARIFARIO_EMISOR_NO_ENCONTRADO = "El Tarifario Emisor %s no existe";
	private final ITarifarioEmisorMapper tarifarioEmisorMapper;
	
	public TarifarioEmisorService(@Qualifier("ITarifarioEmisorMapper") IMantenibleMapper<TarifarioEmisor> mantenibleMapper) {
		super(mantenibleMapper);
		this.tarifarioEmisorMapper = (ITarifarioEmisorMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TarifarioEmisor> buscarTodosTarifariosEmisores() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TarifarioEmisor buscarTarifarioEmisor(int idTarifarioEmisor) {
		return this.tarifarioEmisorMapper.buscarTarifarioEmisor(idTarifarioEmisor).orElseThrow(
				() -> new RecursoNoEncontradoException(TARIFARIO_EMISOR_NO_ENCONTRADO, idTarifarioEmisor));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioEmisor registrarTarifarioEmisor(TarifarioEmisor tarifarioEmisor) {
		this.registrar(tarifarioEmisor);
		return this.buscarTarifarioEmisor(tarifarioEmisor.getIdTarifarioEmisor());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioEmisor actualizarTarifarioEmisor(int idTarifarioEmisor, TarifarioEmisor tarifarioEmisor) {
		tarifarioEmisor.setIdTarifarioEmisor(idTarifarioEmisor);
		this.actualizar(tarifarioEmisor);
		return this.buscarTarifarioEmisor(tarifarioEmisor.getIdTarifarioEmisor());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTarifarioEmisor(int idTarifarioEmisor) {
		TarifarioEmisor tarifarioEmisor = TarifarioEmisor.builder().idTarifarioEmisor(idTarifarioEmisor).build();
		this.eliminar(tarifarioEmisor);
	}
	
}
