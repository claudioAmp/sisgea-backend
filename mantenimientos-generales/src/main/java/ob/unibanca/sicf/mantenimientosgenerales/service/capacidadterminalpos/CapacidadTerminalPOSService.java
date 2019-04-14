package ob.unibanca.sicf.mantenimientosgenerales.service.capacidadterminalpos;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.ICapacidadTerminalPOSMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CapacidadTerminalPOS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CapacidadTerminalPOSService extends MantenibleService<CapacidadTerminalPOS> implements ICapacidadTerminalPOSService {
	
	private static final String CAPACIDAD_TERMINAL_POS_NO_ENCONTRADO =
			"No existe la asociación entre el terminal POS %s y la membresía %s";
	private final ICapacidadTerminalPOSMapper capacidadTerminalPOSMapper;
	
	public CapacidadTerminalPOSService(@Qualifier("ICapacidadTerminalPOSMapper") IMantenibleMapper<CapacidadTerminalPOS> mantenibleMapper) {
		super(mantenibleMapper);
		this.capacidadTerminalPOSMapper = (ICapacidadTerminalPOSMapper) mantenibleMapper;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public CapacidadTerminalPOS registrarCapacidadTerminalPOS(String idMembresia, CapacidadTerminalPOS capacidadTerminalPOS) {
		capacidadTerminalPOS.setIdMembresia(idMembresia);
		this.registrar(capacidadTerminalPOS);
		return this.buscarCapacidadTerminalPOS(capacidadTerminalPOS.getIdMembresia(), capacidadTerminalPOS.getIdTerminalPOS());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CapacidadTerminalPOS actualizarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS, CapacidadTerminalPOS capacidadTerminalPOS) {
		capacidadTerminalPOS.setIdMembresia(idMembresia);
		capacidadTerminalPOS.setIdTerminalPOS(idTerminalPOS);
		this.actualizar(capacidadTerminalPOS);
		return this.buscarCapacidadTerminalPOS(capacidadTerminalPOS.getIdMembresia(), capacidadTerminalPOS.getIdTerminalPOS());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS) {
		CapacidadTerminalPOS capacidadTerminalPOS = CapacidadTerminalPOS.builder().idMembresia(idMembresia).idTerminalPOS(idTerminalPOS).build();
		this.eliminar(capacidadTerminalPOS);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CapacidadTerminalPOS> buscarTodosCapacidadesTerminalesPOS() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CapacidadTerminalPOS buscarCapacidadTerminalPOS(String idMembresia, String idTerminalPOS) {
		return this.capacidadTerminalPOSMapper.buscarCapacidadTerminalPOS(idMembresia, idTerminalPOS).orElseThrow(
				() -> new RecursoNoEncontradoException(CAPACIDAD_TERMINAL_POS_NO_ENCONTRADO, idTerminalPOS, idMembresia));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CapacidadTerminalPOS> buscarCapacidadesTerminalesPOSPorMembresia(String idMembresia) {
		return this.capacidadTerminalPOSMapper.buscarCapacidadesTerminalesPOSPorMembresia(idMembresia);
	}
	
}
