package edu.taller.sisgea.tarifarios.service.escenariotarifa;

import edu.taller.sisgea.tarifarios.model.EscenarioTarifa;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.tarifarios.mapper.IEscenarioTarifaMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EscenarioTarifaService extends MantenibleService<EscenarioTarifa>  implements IEscenarioTarifaService {
	
	private static final String ESCENARIO_TARIFA_NO_ENCONTRADO = "El Escenario Tarifa %s no existe";
	private final IEscenarioTarifaMapper escenarioTarifaMapper;
	
	public EscenarioTarifaService(@Qualifier("IEscenarioTarifaMapper") IMantenibleMapper<EscenarioTarifa> mantenibleMapper) {
		super(mantenibleMapper);
		this.escenarioTarifaMapper = (IEscenarioTarifaMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EscenarioTarifa registrarEscenarioTarifa(EscenarioTarifa escenarioTarifa) {
		this.registrar(escenarioTarifa);
		return this.buscarEscenarioTarifa(escenarioTarifa.getIdEscenarioTarifa());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public EscenarioTarifa actualizarEscenarioTarifa(int idEscenarioTarifa, EscenarioTarifa escenarioTarifa) {
		escenarioTarifa.setIdEscenarioTarifa(idEscenarioTarifa);
		this.actualizar(escenarioTarifa);
		return this.buscarEscenarioTarifa(escenarioTarifa.getIdEscenarioTarifa());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarEscenarioTarifa(int idEscenarioTarifa) {
		EscenarioTarifa escenarioTarifa = EscenarioTarifa.builder().idEscenarioTarifa(idEscenarioTarifa).build();
		this.eliminar(escenarioTarifa);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EscenarioTarifa> buscarTodosEscenariosTarifas() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public EscenarioTarifa buscarEscenarioTarifa(int idEscenarioTarifa) {
		return this.escenarioTarifaMapper.buscarEscenarioTarifa(idEscenarioTarifa).orElseThrow(
				() -> new RecursoNoEncontradoException(ESCENARIO_TARIFA_NO_ENCONTRADO, idEscenarioTarifa));
	}
	
}
