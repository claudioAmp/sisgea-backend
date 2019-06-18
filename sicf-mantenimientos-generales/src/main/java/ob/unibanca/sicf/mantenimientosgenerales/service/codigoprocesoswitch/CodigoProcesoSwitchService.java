package ob.unibanca.sicf.mantenimientosgenerales.service.codigoprocesoswitch;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.ICodigoProcesoSwitchMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoProcesoSwitchService extends MantenibleService<CodigoProcesoSwitch>
		implements ICodigoProcesoSwitchService {
	
	private static final String CODIGO_PROCESO_SWITCH_NO_ENCONTRADO = "El Código Proceso Switch %s no existe";
	private final ICodigoProcesoSwitchMapper codigoProcesoSwitchMapper;
	
	public CodigoProcesoSwitchService(
			@Qualifier("ICodigoProcesoSwitchMapper") IMantenibleMapper<CodigoProcesoSwitch> mantenibleMapper) {
		super(mantenibleMapper);
		this.codigoProcesoSwitchMapper = (ICodigoProcesoSwitchMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoProcesoSwitch registrarCodigoProcesoSwitch(CodigoProcesoSwitch codigoProcesoSwitch) {
		this.registrar(codigoProcesoSwitch);
		return this.buscarCodigoProcesoSwitch(codigoProcesoSwitch.getIdCodigoProcesoSwitch());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoProcesoSwitch actualizarCodigoProcesoSwitch(String idCodigoProcesoSwitch,
	                                                         CodigoProcesoSwitch codigoProcesoSwitch) {
		codigoProcesoSwitch.setIdCodigoProcesoSwitch(idCodigoProcesoSwitch);
		this.actualizar(codigoProcesoSwitch);
		return this.buscarCodigoProcesoSwitch(codigoProcesoSwitch.getIdCodigoProcesoSwitch());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCodigoProcesoSwitch(String idCodigoProcesoSwitch) {
		CodigoProcesoSwitch codigoProcesoSwitch = CodigoProcesoSwitch.builder().idCodigoProcesoSwitch(
				idCodigoProcesoSwitch).build();
		this.eliminar(codigoProcesoSwitch);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CodigoProcesoSwitch> buscarTodosCodigoProcesoSwitches() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public CodigoProcesoSwitch buscarCodigoProcesoSwitch(String idCodigoProcesoSwitch) {
		return this.codigoProcesoSwitchMapper.buscarCodigoProcesoSwitch(idCodigoProcesoSwitch).orElseThrow(
				() -> new RecursoNoEncontradoException(CODIGO_PROCESO_SWITCH_NO_ENCONTRADO, idCodigoProcesoSwitch));
	}
}
