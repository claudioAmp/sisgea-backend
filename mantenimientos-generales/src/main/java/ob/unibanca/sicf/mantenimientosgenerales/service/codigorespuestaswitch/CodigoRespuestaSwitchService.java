package ob.unibanca.sicf.mantenimientosgenerales.service.codigorespuestaswitch;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoRespuestaSwitch;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoRespuestaSwitchService extends MantenibleService<CodigoRespuestaSwitch>
		implements ICodigoRespuestaSwitchService {
	
	public CodigoRespuestaSwitchService(
			@Qualifier("ICodigoRespuestaSwitchMapper") IMantenibleMapper<CodigoRespuestaSwitch> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CodigoRespuestaSwitch> buscarTodosCodigoRespuetaSwitches() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoRespuestaSwitch registrarCodigoRespuestaSwitch(CodigoRespuestaSwitch codigoRespuestaSwitch) {
		this.registrar(codigoRespuestaSwitch);
		return codigoRespuestaSwitch;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CodigoRespuestaSwitch actualizarCodigoRespuestaSwitch(String idCodigoRespuestaSwitch,
	                                                             CodigoRespuestaSwitch codigoRespuestaSwitch) {
		codigoRespuestaSwitch.setIdCodigoRespuestaSwitch(idCodigoRespuestaSwitch);
		this.actualizar(codigoRespuestaSwitch);
		return codigoRespuestaSwitch;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarCodigoRespuestaSwitch(String idCodigoRespuestaSwitch) {
		CodigoRespuestaSwitch codigoRespuestaSwitch = CodigoRespuestaSwitch.builder().idCodigoRespuestaSwitch(
				idCodigoRespuestaSwitch).build();
		this.eliminar(codigoRespuestaSwitch);
	}
}
