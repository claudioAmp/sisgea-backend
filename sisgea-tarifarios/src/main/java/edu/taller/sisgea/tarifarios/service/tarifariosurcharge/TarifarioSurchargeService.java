package edu.taller.sisgea.tarifarios.service.tarifariosurcharge;

import edu.taller.sisgea.tarifarios.mapper.ITarifarioSurchargeMapper;
import edu.taller.sisgea.tarifarios.model.TarifarioSurcharge;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarifarioSurchargeService extends MantenibleService<TarifarioSurcharge> implements ITarifarioSurchargeService {
	
	private static final String TARIFARIO_SURCHARGE_NO_ENCONTRADO = "El Tarifario Surcharge %s no existe";
	private final ITarifarioSurchargeMapper tarifarioSurchargeMapper;
	
	public TarifarioSurchargeService(@Qualifier("ITarifarioSurchargeMapper") IMantenibleMapper<TarifarioSurcharge> mantenibleMapper) {
		super(mantenibleMapper);
		this.tarifarioSurchargeMapper = (ITarifarioSurchargeMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TarifarioSurcharge> buscarTodosTarifariosSurcharges() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TarifarioSurcharge buscarTarifarioSurcharge(int idTarifarioSurcharge) {
		return this.tarifarioSurchargeMapper.buscarTarifarioSurcharge(idTarifarioSurcharge).orElseThrow(
				() -> new RecursoNoEncontradoException(TARIFARIO_SURCHARGE_NO_ENCONTRADO, idTarifarioSurcharge));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioSurcharge registrarTarifarioSurcharge(TarifarioSurcharge tarifarioSurcharge) {
		this.registrar(tarifarioSurcharge);
		return this.buscarTarifarioSurcharge(tarifarioSurcharge.getIdTarifarioSurcharge());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TarifarioSurcharge actualizarTarifarioSurcharge(int idTarifarioSurcharge, TarifarioSurcharge tarifarioSurcharge) {
		tarifarioSurcharge.setIdTarifarioSurcharge(idTarifarioSurcharge);
		this.actualizar(tarifarioSurcharge);
		return this.buscarTarifarioSurcharge(tarifarioSurcharge.getIdTarifarioSurcharge());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarTarifarioSurcharge(int idTarifarioSurcharge) {
		TarifarioSurcharge tarifarioSurcharge = TarifarioSurcharge.builder().idTarifarioSurcharge(idTarifarioSurcharge).build();
		this.eliminar(tarifarioSurcharge);
	}
	
}
